# DNS介绍 #

DNS（Internet Domain Name System）中包含了用来按照一种分层结构定义Internet
上使用的主机名字的语法，还有名字的授权规则，以及为了定义名字和IP 地址的对应，
系统需要进行的所有设置。
实际上，DNS 是一个分布式数据库。它允许对整个数据库的各个部分进行本地控
制；同时整个网络也能通过客户……服务器方式访问每个部分的数据，借助备份和缓存
机制，DNS 将更强壮和足够的性能。
DNS 数据库的结构如图1.1 所示，就象一棵倒挂着的树。

![http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/dns/DNS_struct.jpg](http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/dns/DNS_struct.jpg)


# DNS工作原理 #

当DNS客户端需要为某个应用程序查询名字时，它将联系自己的DNS服务器来解析此名字。DNS客户发送的解析请求包含以下三种信息：

  1. 需要查询的域名。如果原应用程序提交的不是一个完整的[FQDN](http://baike.baidu.com/view/281582.htm)，则DNS客户端加上域名后缀以构成一个完整的[FQDN](http://baike.baidu.com/view/281582.htm)；
  1. 指定的查询类型。指定查询的资源记录的类型，如A记录或者MX记录等等；
  1. 指定的DNS域名类型。对于DNS客户端服务，这个类型总是指定为 Internet `[`IN`]`类别。

### DNS客户端完整的DNS解析过程如下： ###

#### 1、检查自己的本地DNS名字缓存 ####

当DNS客户端需要解析某个FQDN时，先检查自己的本地DNS名字缓存。本地的DNS名字缓存由两部分构成：
  1. Hosts文件中的主机名到IP地址映射定义；
  1. 前一次DNS查询得到的结果，并且此结果还处于有效期；

如果DNS客户端从本地缓存中获得相应结果，则DNS解析完成。

#### 2、联系自己的DNS服务器 ####

如果DNS客户端没有在自己的本地缓存中找到对应的记录，则联系自己的DNS服务器，你必须预先配置DNS客户端所使用的DNS服务器。

当DNS服务器接收到DNS客户端的解析请求后，它先检查自己是否能够**权威答复**此解析请求，即它是否管理此请求记录所对应的DNS区域；如果DNS服务器管理对应的DNS区域，则DNS服务器对此DNS区域具有权威。此时，如果本地区域中的相应资源记录匹配客户的解析请求，则DNS服务器权威的使用此资源记录答复客户的解析请求（**权威答复**）；如果没有相应的资源记录，则DNS服务器权威的答复客户无对应的资源记录（**否定答复**）。

如果没有区域匹配DNS客户端发起的解析请求，则DNS服务器检查自己的本地缓存。如果具有对应的匹配结果，无论是**正向答复**还是**否定答复**，DNS服务器非权威的答复客户的解析请求。此时，DNS解析完成。

如果DNS服务器在自己的本地缓存中还是没有找到匹配的结果，此时，根据配置的不同，DNS服务器执行请求查询的方式也不同：**递归查询**和**迭代查询**。

默认情况下，DNS服务器使用递归方式来解析名字。递归方式的含义就是DNS服务器作为DNS客户端向其他DNS服务器查询此解析请求，直到获得解析结果，在此过程中，原DNS客户端则等待DNS服务器的回复。

如果你禁止DNS服务器使用递归方式，则DNS服务器工作在迭代方式，即向原DNS客户端返回一个参考答复，其中包含有利于客户端解析请求的信息（例如根提示信息等），而不再进行其他操作；原DNS客户端根据DNS服务器返回的参考信息再决定处理方式。但是在实际网络环境中，禁用DNS服务器的递归查询往往会让DNS服务器对无法进行本地解析的客户端请求返回一个服务器失败的参考答复，此时，客户端则会认为解析失败。

递归方式和迭代方式的不同之处就是当DNS服务器没有在本地完成客户端的请求解析时，由谁扮演DNS客户端的角色向其他DNS服务器发起解析请求。通常情况下应使用递归方式，这样有利于网络管理和安全性控制，只是递归方式比迭代方式更消耗DNS服务器的性能，不过在通常的情况下，这点性能的消耗无关紧要。

根提示信息是Internet命名空间中的根DNS服务器的IP地址。为了正常的执行递归解析，DNS服务器必须知道从哪儿开始搜索DNS域名，而根提示信息则用于实现这一需求。全世界范围内的根DNS服务器总共有13个，它们的名字和IP地址信息保存在/etc/bind/db.root文件中，每次DNS服务器启动时从db.root文件中读取。一般情况下，不需要对此文件进行修改；如果你的DNS服务器是在内部网络中部署并且不需要使用Internet的根DNS服务器，则可以根据需要进行修改，将其指向到某个内部根域DNS服务器。

**例如，当某个DNS客户端请求解析域名[www.test.org]，完整的解析过程如下：**

  1. DNS客户端检查自己的本地名字缓存，没有找到对应的记录；
  1. DNS客户端联系自己的DNS服务器NameServer1，查询域名 [www.test.org]；
  1. NameServer1检查自己的权威区域和本地缓存，没有找到对应值。于是，联系根提示中的某个根域服务器，查询域名[www.test.org]；
  1. 根域服务器也不知道[www.test.org]的对应值，于是，向NameServer1返回一个参考答复，告诉NameServer1  .org顶级域的权威DNS服务器；
  1. NameServer1联系 .org顶级域的权威DNS服务器，查询域名[www.test.org]；
  1. .org顶级域服务器也不知道[www.test.org]的对应值，于是，向NameServer1返回一个参考答复，告诉NameServer1 test.org域的权威DNS服务器；
  1. NameServer1联系test.org域的权威DNS服务器，查询域名[www.test.org]；
  1. test.org域的权威DNS服务器知道对应值，并且返回给NameServer1；
  1. NameServer1向原DNS客户端返回[www.test.org]的结果，此时，解析完成。

![http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/dns/DNS_query.jpg](http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/dns/DNS_query.jpg)

### DNS跟踪 ###

```
dig www.baidu.com +trace

; <<>> DiG 9.6-ESV-R3 <<>> www.baidu.com +trace
;; global options: +cmd
.                       30529   IN      NS      m.root-servers.net.
.                       30529   IN      NS      i.root-servers.net.
.                       30529   IN      NS      f.root-servers.net.
.                       30529   IN      NS      a.root-servers.net.
.                       30529   IN      NS      b.root-servers.net.
.                       30529   IN      NS      c.root-servers.net.
.                       30529   IN      NS      k.root-servers.net.
.                       30529   IN      NS      j.root-servers.net.
.                       30529   IN      NS      e.root-servers.net.
.                       30529   IN      NS      h.root-servers.net.
.                       30529   IN      NS      g.root-servers.net.
.                       30529   IN      NS      d.root-servers.net.
.                       30529   IN      NS      l.root-servers.net.
;; Received 228 bytes from 8.8.8.8#53(8.8.8.8) in 119 ms

com.                    172800  IN      NS      a.gtld-servers.net.
com.                    172800  IN      NS      b.gtld-servers.net.
com.                    172800  IN      NS      c.gtld-servers.net.
com.                    172800  IN      NS      d.gtld-servers.net.
com.                    172800  IN      NS      e.gtld-servers.net.
com.                    172800  IN      NS      f.gtld-servers.net.
com.                    172800  IN      NS      g.gtld-servers.net.
com.                    172800  IN      NS      h.gtld-servers.net.
com.                    172800  IN      NS      i.gtld-servers.net.
com.                    172800  IN      NS      j.gtld-servers.net.
com.                    172800  IN      NS      k.gtld-servers.net.
com.                    172800  IN      NS      l.gtld-servers.net.
com.                    172800  IN      NS      m.gtld-servers.net.
;; Received 503 bytes from 198.41.0.4#53(a.root-servers.net) in 435 ms

baidu.com.              172800  IN      NS      dns.baidu.com.
baidu.com.              172800  IN      NS      ns2.baidu.com.
baidu.com.              172800  IN      NS      ns3.baidu.com.
baidu.com.              172800  IN      NS      ns4.baidu.com.
;; Received 167 bytes from 192.12.94.30#53(e.gtld-servers.net) in 615 ms

www.baidu.com.          1200    IN      CNAME   www.a.shifen.com.
a.shifen.com.           86422   IN      NS      ns5.a.shifen.com.
a.shifen.com.           86422   IN      NS      ns6.a.shifen.com.
a.shifen.com.           86422   IN      NS      ns4.a.shifen.com.
a.shifen.com.           86422   IN      NS      ns2.a.shifen.com.
;; Received 194 bytes from 220.181.38.10#53(ns4.baidu.com) in 7 ms
```

# DNS记录类型 #

请查阅[DNS记录类型](DNS_Recode_Type.md)

# Nevel DNS #


由上描述可知，
  1. Nevel DNS应为在例子中的权威域名服务器，故网站管理员将test.org的NS记录指向Nevel DNS，由Nevel DNS来做权威解答。
  1. 向Nevel DNS做查询的是ISP DNS，而非真正客户端，故做智能DNS的时候判断的是ISP DNS所在位置而非客户端，也就是说存在极端情况是网通客户端配置了电信的DNS服务器，智能DNS服务将返回电信服务器


# 参考 #


| **RFC** | **标题** |
|:--------|:-----------|
|1034|域名 - 概念和工具|
|1035|域名 - 实现和规范|
|1123|Internet 主机 - 应用和支持的要求|
|1886|支持 IP 版本 6 的 DNS 扩展名|
|1995|DNS 中的增量区域传输|
|1996|提示通知区域更改的机制 (DNS NOTIFY)|
|2136|域名系统中的动态更新 (DNS UPDATE)|
|2181|对 DNS 规范的说明|
|2308|DNS 查询的负缓存 (DNS NCACHE)|
|2535|域名系统安全扩展 (DNSSEC)|
|2671|DNS 的扩展机制 (EDNS0)|
|2782|指定服务位置的 DNS RR (DNS SRV)|
|2930|DNS 的密钥建立 (TKEY RR)|
|3645|DNS (GSS-TSIG) 密钥事务身分验证的通用安全服务算法|
|3646|IPv6 (DHCPv6) 动态主机配置协议的 DNS 配置选项|


### 参考资料 ###
`[1].` https://code.google.com/p/nevel-jupiter/wiki/DNS<br>