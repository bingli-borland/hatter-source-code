下载ZooKeeper: http://zookeeper.apache.org/releases.html

```
@conf

cp zoo_sample.cfg zoo.cfg
```

```
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/home/admin/zookeeper/data
clientPort=2181

server.1=c1.hatter.zj.cn:2888:3888 
server.2=b1.hatter.zj.cn:2888:3888 
server.3=a1.hatter.zj.cn:2888:3888

// 观察者，无投票权
server.4=d1.hatter.zj.cn:2888:3888:observer
```

在 `/home/admin/zookeeper/data` 建文件 `myid` ，写入对应的ID号。再通过 `./zkServer.sh start` 挨个启动即可。

客户端连接到ZooKeeper服务器：
```
./zkCli.sh -server host:port  // default port: 2181
```

Purge Log:
```
java -cp zookeeper-3.4.5.jar:lib/log4j-1.2.15.jar:lib/slf4j-api-1.6.1.jar:lib/slf4j-log4j12-1.6.1.jar:conf org.apache.zookeeper.server.PurgeTxnLog $log_dir$ $data_dir$ -n 6 
```

# 讨论 #
ZooKeeper不适合做什么？ [关于zookeeper的讨论](http://koven2049.iteye.com/blog/1315819)

### 参考资料 ###
`[1].` http://zookeeper.apache.org/doc/r3.3.3/zookeeperProgrammers.html<br>
<code>[2].</code> <a href='http://bbs.zoomla.cn/archiver/showtopic-15086.aspx'>http://bbs.zoomla.cn/archiver/showtopic-15086.aspx</a><br>
<code>[3].</code> <a href='http://www.cnblogs.com/gpcuster/archive/2010/01/15/1648547.html'>http://www.cnblogs.com/gpcuster/archive/2010/01/15/1648547.html</a><br>
<code>[4].</code> <a href='http://rdc.taobao.com/team/jm/archives/category/rpc-soa'>http://rdc.taobao.com/team/jm/archives/category/rpc-soa</a><br>