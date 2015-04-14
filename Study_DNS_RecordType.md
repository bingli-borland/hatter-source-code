# 记录类型 #

|代码|号码|定义的 RFC|描述|功能|
|:-----|:-----|:------------|:-----|:-----|
|A |1 |RFC 1035|IP 地址记录|传回一个 32 位的 IPv4 地址，最常用于映射主机名称到 IP地址，但也用于DNSBL（RFC 1101）等。|
|AAAA|28|RFC 3596|IPv6 IP 地址记录|传回一个 128 位的 IPv6 地址，最常用于映射主机名称到 IP 地址。|
|AFSDB|18|RFC 1183|AFS文件系统|（Andrew File System）数据库核心的位置，于域名以外的 AFS 客户端常用来联系 AFS 核心。这个记录的子类型是被过时的的 DCE/DFS（DCE Distributed File System）所使用。|
|APL|42|RFC 3123|地址前缀列表|指定地址列表的范围，例如：CIDR 格式为各个类型的地址（试验性）。|
|CERT|37|RFC 4398|凭证记录|存储 PKIX、SPKI、PGP等。|
|CNAME|5 |RFC 1035|规范名称记录|一个主机名字的别名：域名系统将会继续尝试查找新的名字。|
|DHCID|49|RFC 4701|DHCP（动态主机设置协议）识别码|用于将 FQDN 选项结合至 DHCP。|
|DLV|32769|RFC 4431|DNSSEC（域名系统安全扩展）来源验证记录|为不在DNS委托者内发布DNSSEC的信任锚点，与 DS 记录使用相同的格式，RFC 5074 介绍了如何使用这些记录。|
|DNAME|39|RFC 2672|代表名称|DNAME 会为名称和其子名称产生别名，与 CNAME 不同，在其标签别名不会重复。但与 CNAME 记录相同的是，DNS将会继续尝试查找新的名字。|
|DNSKEY|48|RFC 4034|DNS 关键记录|于DNSSEC内使用的关键记录，与 KEY 使用相同格式。|
|DS|43|RFC 4034|委托签发者|此记录用于鉴定DNSSEC已授权区域的签名密钥。|
|HIP|55|RFC 5205|主机鉴定协议|将端点标识符及IP 地址定位的分开的方法。|
|IPSECKEY|45|RFC 4025|IPSEC 密钥|与 IPSEC 同时使用的密钥记录。|
|KEY|25|RFC 2535[1](1.md) RFC 2930[2](2.md)|关键记录|只用于 SIG(0)（RFC 2931）及 TKEY（RFC 2930）。[3](3.md) RFC 3455 否定其作为应用程序键及限制DNSSEC的使用。[4](4.md) RFC 3755 指定了 DNSKEY 作为DNSSEC的代替。[5](5.md)|
|LOC记录（LOC record）|29|RFC 1876|位置记录|将一个域名指定地理位置。|
|MX记录（MX record）|15|RFC 1035|电邮交互记录|引导域名到该域名的邮件传输代理（MTA, Message Transfer Agents）列表。|
|NAPTR记录（NAPTR record）|35|RFC 3403|命名管理指针|允许基于正则表达式的域名重写使其能够作为 URI、进一步域名查找等。|
|NS|2 |RFC 1035|名称服务器记录|委托DNS区域（DNS zone）使用已提供的权威域名服务器。|
|NSEC|47|RFC 4034|下一代安全记录|DNSSEC 的一部份 — 用来验证一个未存在的服务器，使用与 NXT（已过时）记录的格式。|
|NSEC3|50|RFC 5155|NSEC 记录第三版|用作允许未经允许的区域行走以证明名称不存在性的 DNSSEC 扩展。|
|NSEC3PARAM|51|RFC 5155|NSEC3 参数|与 NSEC3 同时使用的参数记录。|
|PTR|12|RFC 1035|指针记录|引导至一个规范名称（Canonical Name）。与 CNAME 记录不同，DNS“不会”进行处理程序，只会传回名称。最常用来运行反向 DNS 查找，其他用途包括引作 DNS-SD。|
|RRSIG|46|RFC 4034|DNSSEC 凭证|DNSSEC 安全记录集凭证，与 SIG 记录使用相同的格式。|
|RP|17|RFC 1183|负责人|有关域名负责人的信息，电邮地址的 @ 通常写为 a。|
|SIG|24|RFC 2535|凭证|SIG(0)（RFC 2931）及 TKEY（RFC 2930）使用的凭证。[5](5.md) RFC 3755 designated RRSIG as the replacement for SIG for use within DNSSEC.[5](5.md)|
|SOA|6 |RFC 1035|权威记录的起始|指定有关DNS区域的权威性信息，包含主要名称服务器、域名管理员的电邮地址、域名的流水式编号、和几个有关刷新区域的定时器。|
|SPF|99|RFC 4408|SPF 记录|作为 SPF 协议的一部分，优先作为先前在 TXT 存储 SPF 数据的临时做法，使用与先前在 TXT 存储的格式。|
|SRV记录（SRV record）|33|RFC 2782|服务定位器|广义为服务定位记录，被新式协议使用而避免产生特定协议的记录，例如：MX 记录。|
|SSHFP|44|RFC 4255|SSH 公共密钥指纹|DNS 系统用来发布 SSH 公共密钥指纹的资源记录，以用作辅助验证服务器的真实性。|
|TA|32768|无|DNSSEC 信任当局|DNSSEC 一部份无签订 DNS 根目录的部署提案，，使用与 DS 记录相同的格式[6](6.md) [7](7.md)。|
|TKEY记录（TKEY record）|249|RFC 2930|秘密密钥记录|为TSIG提供密钥材料的其中一类方法，that is 在公共密钥下加密的 accompanying KEY RR。[8](8.md)|
|TSIG|250|RFC 2845|交易凭证|用以认证动态更新（Dynamic DNS）是来自合法的客户端，或与 DNSSEC 一样是验证回应是否来自合法的递归名称服务器。[9](9.md)|
|TXT|16|RFC 1035|文本记录|最初是为任意可读的文本 DNS 记录。自1990年起，些记录更经常地带有机读数据，以 RFC 1464 指定：opportunistic encryption、Sender Policy Framework（虽然这个临时使用的 TXT 记录在 SPF 记录推出后不被推荐）、DomainKeys、DNS-SD等。|


# 其他类型及伪资源记录 #

其他类型的资源记录简单地提供一些类型的消息（如：HINFO 记录提供电脑或操作系统的类型），或传回实验中之功能的数据。“type”字段也使用于其他协议作各种操作。

|代码|号码|定义的 RFC|描述|功能|
|:-----|:-----|:------------|:-----|:-----|
|`*`|255|RFC 1035|所有缓存的记录|传回所有服务器已知类型的记录。如果服务器未有任何关于名称的记录，该请求将被转发。而传回的记录未必完全完成，例如：当一个名称有 A 及 MX 类型的记录时，但服务器已缓存了 A 记录，就只有 A 记录会被传回。|
|AXFR|252|RFC 1035|全局转移|由主域名服务器转移整个区域文件至二级域名服务器。|
|IXFR|251|RFC 1995|增量区域转移|请求只有与先前流水式编号不同的特定区域的区域转移。此请求有机会被拒绝，如果权威服务器由于配置或缺乏必要的数据而无法履行请求，一个完整的（AXFR）会被发送以作回应。|
|OPT|41|RFC 2671|选项|这是一个“伪 DNS记录类型”以支持 EDNS。|


### 参考资料 ###
`[1].` https://code.google.com/p/nevel-jupiter/wiki/DNS_Recode_Type<br>
<code>[2].</code> <a href='http://en.wikipedia.org/wiki/List_of_DNS_record_types'>http://en.wikipedia.org/wiki/List_of_DNS_record_types</a><br>