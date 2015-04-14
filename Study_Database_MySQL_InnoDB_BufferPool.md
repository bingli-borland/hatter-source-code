`innodb_old_blocks_time` - 配置Buffer Pool在表扫描时是否会被污染，默认是`0`，单位`ms`，设置参考值`1000`


---


## 1. Buffer Pool中LRU缺点、细节 ##

这样LRU算法的一个缺点是，如果有某一个查询做了一次全表扫描（例如备份，临时DDL等），都可能会导致整个Buffer Pool中LRU链表中的数据块都被替换了，甚至很多热点数据也会被替换，而这些新进的数据块可能在这一次查询之后就再也不会被读到了。我们也称这种情况为“Buffer Pool被污染”了。

在InnoDB则引入了一些新的机制来避免这种情况。算法仍然是LRU算法，但是加上了中点策略（类似于MyISAM的key buffer中的midpoint strategy）。同时引入了参数`innodb_old_blocks_time`来控制Buffer Pool不被污染。

LRU链表中的数据分为两部分：Sublist of new和Sublist of old。后者包含访问最近没有访问的数据块（链表越后面的数据块，最近越没有被访问）。默认情况，前者占63%（5/8），后者37%（3/8）。

![http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/database/mysql/buffer_pool_lru_list.png](http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/database/mysql/buffer_pool_lru_list.png)

当数据块需要从数据文件中读取时，首先会放到old sublist的头部（midpoint）。然后，如果有对这个数据块的访问，那么就将这个数据块放到new sublist的首部。一般来说，一个数据块被取出后，立刻会有读取，也就很快会被放到new sublist的头部。一种糟糕的情况是，如果是mysqldump访问全部数据块，也就会导致所有的数据块被放到new sublist。这样Buffer Pool也就全部被污染了。


## 2. Buffer Pool中LRU队列如何防止污染 ##

InnoDB Plugin通过引入如下的参数来防止“污染”：

`innodb_old_blocks_pct`： 控制old sublist在LRU队列的长度

`innodb_old_blocks_time`：该参数决定了，当Block被插入到midpoint（old sublist）后，必须要在old sublist停留超过`innodb_old_blocks_time`（ms）时间后，才有可能被转移到new sublist。例如，将`innodb_old_blocks_time`设置为1000（即1s），当出现Table scan出现时，InnoDB先将数据块载入到midpoint（old sublist）上，程序读取数据块，因为这时，数据块在old sublist中的停留时间还不到`innodb_old_blocks_time`，所以不会被转移到new sublist中。这就避免了Buffer Pool被污染的情况。更酷的是，这个参数是动态调整的，所以在做意外的Table scan时，动态调整一下该参数就可以了。


## 3. 防污染的效率观察 ##

可以根据`SHOW INNODB STATUS\G`中Buffer Pool段开看看相关效率：

```
Total memory allocated 1107296256; in additional pool allocated 0
Dictionary memory allocated 80360
Buffer pool size 65535
Free buffers 0
Database pages 63920
Old database pages 23600
Modified db pages 34969
Pending reads 32
Pending writes: LRU 0, flush list 0, single page 0
Pages made young 414946, not young 2930673
1274.75 youngs/s, 16521.90 non-youngs/s
Pages read 486005, created 3178, written 160585
2132.37 reads/s, 3.40 creates/s, 323.74 writes/s
Buffer pool hit rate 950 / 1000, young-making rate 30 / 1000 not 392 / 1000
Pages read ahead 1510.10/s, evicted without access 0.00/s
LRU len: 63920, unzip_LRU len: 0
I/O sum[43690]:cur[221], unzip sum[0]:cur[0]
```

解释：Old database pages 表示LRU列表中old sublist中的数据块数量。

Pages made young and not young表示old sublist中有多少数据块是（没）被转移到new sublist。

`youngs/s and non-young/s` 从上次执行`SHOW INNODB STATUS`到现在为止，访问Old sublist时有多少将数据块转移到new sublist，有多少是没有转移的（这里可以看出参数`innodb_old_blocks_time`的效率）。

young-making rate and not 反映的是全部Buffer Pool访问中，将（没有将）old sublist中转移new sublist的比率。
### 参考资料 ###
`[1].` http://www.orczhou.com/index.php/2010/05/innodb-plugin-make-buffer-cache-scan-resistant/<br>