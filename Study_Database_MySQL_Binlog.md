## 打开binlog ##
文件 `my.cnf` :
```
binlog-format=(mixed|row|statement)

log-bin=master-bin
log-bin-index=master-bin.index
```

```
SHOW VARIABLES LIKE 'binlog_format';

SHOW VARIABLES LIKE "server_id";
```


```
show master status;

show slave status;

show slave hosts;
```

```
show binlog events [in 'mysqlbin-bin.000001'] [from 1000] [limit 10];

SAMPLE:
mysql> show binlog events in 'mysql-bin.004863' from 346035617 limit 23;
ERROR 1220 (HY000): Error when executing command SHOW BINLOG EVENTS: Wrong offset or I/O error

$ mysqlbinlog mysql-bin.000001
```

```
purge binary logs to 'binglogfilename';  // 当前指定的版本是不删除的
```

slave记录relaylog的binlog <sup>[3]</sup>：
```
 --log-slave-updates
```


### 参考资料 ###
`[1].` http://www.taobaodba.com/html/474_mysqls-binary-log_details.html<br>
<code>[2].</code> <a href='http://www.packtpub.com/article/setting-up-mysql-replication-for-high-availability'>http://www.packtpub.com/article/setting-up-mysql-replication-for-high-availability</a><br>
<code>[3].</code> <a href='http://dev.mysql.com/doc/refman/5.0/en/replication-options-slave.html'>http://dev.mysql.com/doc/refman/5.0/en/replication-options-slave.html</a><br>