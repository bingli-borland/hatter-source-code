1、概述

IETF（互联网工程任务组—The Internet Engineering Task Force）是松散的、自律的、志愿的民间学术组织，成立于1985年底, 其主要任务是负责互联网相关技术规范的研发和制定。

IETF是一个由为互联网技术工程及发展做出贡献的专家自发参与和管理的国际民间机构。它汇集了与互联网架构演化和互联网稳定运作等业务相关的网络设计者、运营者和研究人员，并向所有对该行业感兴趣的人士开放。任何人都可以注册参加IETF的会议。IETF大会每年举行三次，规模均在千人以上。

IETF大量的技术性工作均由其内部的各类工作组协作完成。这些工作组按不同类别，如路由、传输、安全等专项课题而分别组建。IETF的交流工作主要是在各个工作组所设立的邮件组中进行，这也是IETF的主要工作方式。

目前，IETF已成为全球互联网界最具权威的大型技术研究组织。但是它有别于像国际电联(ITU-International Telecommunication Union)这样的传统意义上的标准制定组织。IETF的参与者都是志愿人员，他们大多是通过IETF每年召开的三次会议来完成该组织的如下使命：

  1. 鉴定互联网的运行和技术问题，并提出解决方案；
  1. 详细说明互联网协议的发展或用途，解决相应问题；
  1. 向IESG提出针对互联网协议标准及用途的建议；
  1. 促进互联网研究任务组(IRTF)的技术研究成果向互联网社区推广；
  1. 为包括互联网用户、研究人员、行销商、制造商及管理者等提供信息交流的论坛。

2、IETF相关组织机构

![http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/ietf/ietf.png](http://hatter-source-code.googlecode.com/svn/trunk/attachments/wiki/ietf/ietf.png)


> （1）互联网协会(ISCO -Internet Society)

> ISCO是一个国际的，非盈利性的会员制组织，其作用是促进互联网在全球范围的应用。实现方式之一便是对各类互联网组织提供财政和法律支持，特别是对IAB管理下的IETF提供资助。

> （2）互联网架构委员会(IAB-Internet Architecture Board)

> IAB是ISOC的技术咨询团体，承担ISCO技术顾问组的角色；IAB负责定义整个互联网的架构和长期发展规划，通过IESG向IETF提供指导并协调各个IETF工作组的活动，在新的IETF工作组设立之前IAB负责审查此工作组的章程，从而保证其设置的合理性，因此可以认为IAB是IETF的最高技术决策机构。

> 另外，IAB还是IRTF的组织和管理者，负责召集特别工作组对互联网结构问题进行深入的研讨。

> （3）互联网工程指导组(IESG-Internet Engineering Steering Group)

> IETF的工作组被分为8个重要的研究领域，每个研究领域均有1-3名领域管理者（Ads—Area Directors），这些领域管理者ADs均是IESG的成员。

> IESG负责IETF活动和标准制定程序的技术管理工作，核准或纠正IETF各工作组的研究成果，有对工作组的设立终结权，确保非工作组草案在成为请求注解文件(RFC)时的准确性。

> 作为ISOC（Internet协会）的一部分，它依据ISOC理事会认可的条例规程进行管理。可以认为IESG是IETF的实施决策机构。

> IESG的成员也由任命委员会（Nomcom－Nominations Committee）选举产生，任期两年。

> （4）互联网编号分配机构(IANA-Internet Assigned Numbers Authority)

> IANA在ICANN的管理下负责分配与互联网协议有关的参数（IP地址、端口号、域名以及其它协议参数等）。IAB指定IANA在某互联网协议发布后对其另增条款进行说明协议参数的分配与使用情况。

> IANA的活动由ICANN资助。IANA与IAB是合作的关系。

> （5）RFC编辑者（RFC Editors）

> 主要职责是与IESG协同工作，编辑、排版和发表RFC。RFC一旦发表就不能更改。如果标准在叙述上有变，则必须重新发表新的RFC并替换掉原先版本。该机构的组成和实施的政策由IAB掌控。

> （6）IETF秘书处（RFC Secretariat）

> 在IETF中进行有偿服务的工作人员很少。IETF秘书处负责会务及一些特殊邮件组的维护，并负责更新和规整官方互联网草案目录，维护IETF网站，辅助IESG的日常工作。

> （7）互联网研究任务组(IRTF-The Internet Research Task Force)

> IRTF由众多专业研究小组构成，研究互联网协议、应用、架构和技术。其中多数是长期运作的小组，也存在少量临时的短期研究小组。各成员均为个人代表，并不代表任何组织的利益。

3、IETF标准的种类

> IETF各工作组的标准研究包括：互联网草案（Internet-Draft）和技术规范（RFC）,对任何人免费公开。

> 互联网草案任何人都可以提交，没有任何特殊限制，而且其他的成员也可以对它采取一个无所谓的态度，而IETF的一些很多重要的文件都是从这个互联网草案开始。

> 互联网技术规范RFC（Request For Comments）是IETF、IESG和IAB的正式出版物，有多种类型，应该注意的是，并不是所有的RFC都是技术标准。其中只有一些RFC是技术标准，另外一些RFC只是参考性报告。

> RFC更为正式，而且历史上都是存档的，它的存在一般来讲，被批准出台以后，它的内容不做改变。

> RFC有好多种：第一个它是一种标准；第二个它是一种试验性的，RFC无非是说我们在一起想做这样一件事情，尝试一下；另一个是文献历史性的，这个是记录了我们曾经做过一件事情是错误的，或者是不工作的；再有一种就是叫做介绍性信息，其实里边什么内容都有。

> 作为标准的RFC又分为几种：

> 第一种是提议性的，就是说建议采用这个作为一个方案而列出。

> 第二种就是完全被认可的标准，这种是大家都在用，而且是不应该改变的。

> 第三种就是现在的最佳实践法，它相当于一种介绍。

> RFC2026中详细定义了互联网标准相关出版物（RFCs和Internet-Drafts）、标准规范（Technical Specifications, Applicability Statements和Requirement Levels）、标准轨迹(包括Proposed Standard, Draft Standard,和Internet Standard)、非标准轨迹(Experimental, Informationa)、废弃/过期标准(Historic)、当前最优实现（Best Current Practice (BCP) RFCs）。其中，只有标准轨迹中的Proposed Standard, Draft Standard, 和Internet Standard这些类型的RFC为各厂家在实现相关技术时所必须遵循的标准。对于发布为建议标准类型（Proposed Standard）的RFC，通过实际使用可升级为草案标准类型（Draft Standard），广泛使用后可升级为互联网标准（Internet Draft）。

> 这些标准产生的过程是一种从下往上的过程，而不是从上往下，也就是说不是一个由主席，或者由工作组负责人的一个指令，说是要做什么大家就做什么，而是由下边自发提出，然后在工作组里讨论，讨论了以后再交给工程指导委员会进行审查。但是工程指导委员会只做审查不做修改，修改还是要拿到工作组进行。IETF工作组标准的产生实际上就是任何人都可以来参加会议，任何人都可以提议，然后他和别人进行讨论，大家形成了一个共识就可以产出这样的标准。

4、IETF的研究领域

> IETF的实际工作大部分是在其工作组（Working Group）中完成的。这些工作组又根据主题的不同划分到若干个领域（Area），如路由、传输和网络安全等。每个领域由一到两名主管（Area Directors）负责管理，所有的领域主管组成了互联网工程组指导组（Internet Engineering Steering Group - IESG）。IETF工作组的许多工作是通过邮件列表（Mailing List）进行的。IETF每年召开三次会议。

> 目前，IETF共包括八个研究领域，132个处于活动状态的工作组。

```
    （1）应用研究领域（app— Applications Area），含20个工作组（Work Group）
    （2）通用研究领域（gen—General Area），含5个工作组
    （3）网际互联研究领域（int—Internet Area），含21个工作组
    （4）操作与管理研究领域（ops—Operations and Management Area），含24个工作组
    （5）路由研究领域（rtg—Routing Area），含14个工作组
    （6）安全研究领域（sec—Security Area），含21个工作组
    （7）传输研究领域（tsv—Transport Area），含1个工作组
    （8）临时研究领域（sub—Sub-IP Area），含27个工作组
```

> 5.1) 应用研究领域（app— Applications Area）

> 虽然IETF的研究范围划定为“Above the wire, Below the application”，即IETF并不关注于应用领域的研究，但是对于与互联网的运营密切相关的应用还是受到了重视，并成立的专门的工作组。

> 目前应用研究领域共包括20个处于活动状态的工作组。随着互联网的发展，这个研究领域的工作组数目还要增长。

```
    Calendaring and Scheduling (calsch) ――日历与时间规划工作组
    Cross Registry Information Service Protocol (crisp) ――交叉注册信息服务协议工作组
    Electronic Data Interchange-Internet Integration (ediint) ――EDI与互联网集成工作组
    Internet Fax (fax) ――互联网传真工作组
    Geographic Location/Privacy (geopriv) ――地理位置工作组
    Internet Message Access Protocol Extension (imapext) ――互联网消息访问扩展工作组
    Instant Messaging and Presence Protocol (impp) ――及时消息协议工作组
    Internet Printing Protocol (ipp) ――互联网打印协议工作组
    LDAP (v3) Revision (ldapbis) ――LDAP修订工作组
    Enhancements to Internet email to support diverse service 
environments (lemonade) ――互联网电子邮件在不同服务环境下的增强
    MTA Authorization Records in DNS (marid) ――DNS中的MTA认证记录工作组
    Message Tracking Protocol (msgtrk) ――消息跟踪协议工作组
    NNTP Extensions (nntpext) ――NNTP扩展工作组
    Open Pluggable Edge Services (opes) ――开放式可插接服务工作组
    SIP for Instant Messaging and Presence Leveraging Extensions 
(simple) ――SIP在及时消息应用中的扩展
    Internet Open Trading Protocol (trade) ――互联网开发交易协议工作组
    Usenet Article Standard Update (usefor)
    Voice Profile for Internet Mail (vpim) ――互联网邮件的语音附件工作组
    WWW Distributed Authoring and Versioning (webdav)
    Extensible Messaging and Presence Protocol (xmpp) ――消息扩展协议工作组
```

> 5.2）通用研究领域（gen—General Area）

> 在IETF中，不能放在其它研究领域的研究内容，就放置在通用研究领域中，因此这个领域的研究内容的内在联系性并不强。目前在这个研究领域共包括5个处于活动状态的工作组。

```
    Improved Cross-Area Review (icar) ――增强跨域工作组
    Intellectual Property Rights (ipr) ――知识产权工作组
    New IETF Standards Track Discussion (newtrk)
    Operation of the IESG/IAB Nominating and Recall Committees (nomcom) ――IESG/IAB选举委员会运作程序
    Problem Statement (problem) ――问题陈述工作组
```

> 5.3）网际互联研究领域（int—Internet Area）

> 网际互联研究领域主要研究IP包如何在不同的网络环境中进行传输，同时也涉及DNS信息的传递方式的研究。

> 这个研究领域在IETF中占据着重要的地位，TCP/IP协议族和IPv6协议族的核心协议均在由这个领域来研究并制订。

```
    Dynamic Host Configuration (dhc) ――动态主机配置工作组
    Detecting Network Attachment (dna) ――网络附属设施监测工作组
    DNS Extensions (dnsext) ――DNS扩展工作组
    Extensible Authentication Protocol (eap) ――可扩展的鉴权协议工作组
    Host Identity Protocol (hip) ――主机标识协议工作组
    IP over DVB (ipdvb)
    IP over InfiniBand (ipoib)
    IP over Resilient Packet Rings (iporpr) ――IP OVER RPR工作组
    IP Version 6 Working Group (ipv6) ――IPv6工作组
    Layer Two Tunneling Protocol Extensions (l2tpext) ――二层隧道协议扩展工作组
    Layer 2 Virtual Private Networks (l2vpn) ――二层虚拟专用网工作组
    Layer 3 Virtual Private Networks (l3vpn) ――三层虚拟专用网工作组
    Multicast & Anycast Group Membership (magma) ――组播与任播工作组
    Mobility for IPv4 (mip4) ――移动IPv4工作组
    Mobility for IPv6 (mip6) ――移动IPv6工作组
    MIPv6 Signaling and Handoff Optimization (mipshop) ――移动IPv6信令与漫游优化工作组
    Network Mobility (nemo) ――网络移动性工作组
    Protocol for carrying Authentication for Network Access (pana) ――接入网认证信息承载协议工作组
    Point-to-Point Protocol Extensions (pppext) ――PPP协议扩展工作组
    Securing Neighbor Discovery (send) ――安全邻居发现协议工作组
    Zero Configuration Networking (zeroconf) ――零配置网络工作组
```

> 5.4）操作与管理研究领域（ops—Operations and Management Area）

> 这个研究领域主要涉及互联网的运作与管理方面的内容。目前共包含24个处于活动状态的工作组，工作组数目处于IETF所有研究领域的第二位。

> 现在随着互联网的快速发展与普及，对于网络的运营与管理提出了更高的要求，因此这个研究领域也越来越受到重视。这个领域的工作组数目还可能增加。

> 这个研究领域中比较重要的研究内容包括AAA（授权、认证、审计）、v6ops（IPv6运维）、rap（资源预留）、dnsop（DNS运维）以及各种MIB的研究。

```
    Authentication, Authorization and Accounting (aaa) ――AAA工作组
    ADSL MIB (adslmib) ――ADSL MIB库工作组
    AToM MIB (atommib) ――ATOM MIB库工作组
    Benchmarking Methodology (bmwg) ――计量方法工作组
    Bridge MIB (bridge) ――网桥MIB库工作组
    Control And Provisioning of Wireless Access Points (capwap) ――无线AP控制与配置协议工作组
    Distributed Management (disman) ――分布式管理工作组
    Domain Name System Operations (dnsop) ――域名操作工作组
    Entity MIB (entmib) ――实体MIB工作组
    Global Routing Operations (grow) ――全局路由运作工作组
    Ethernet Interfaces and Hub MIB (hubmib) ――以太网接口与HUB MIB库工作组
    Internet and Management Support for Storage (imss)
    IP over Cable Data Network (ipcdn)
    IP Flow Information Export (ipfix)
    MBONE Deployment (mboned) ――MBONE布置工作组
    Site Multihoming in IPv6 (multi6) ――IPv6多穴主机工作组
    Network Configuration (netconf) ――网络配置工作组
    Policy Framework (policy) ――策略框架工作组
    Packet Sampling (psamp) ――数据包采样工作组
    Prefix Taxonomy Ongoing Measurement & Inter Network Experiment (ptomaine)
    Resource Allocation Protocol (rap) ――资源分配协议工作组
    Remote Network Monitoring (rmonmib) ――网络远程监控工作组
    Configuration Management with SNMP (snmpconf) ――基于SNMP的配置管理工作组
    IPv6 Operations (v6ops) ――IPv6运维工作组
```

> 5.5）路由研究领域（rtg—Routing Area）

> 此研究领域主要负责制订如何在网络中确定传输路径以将IP包传送到目的地的相关标准。由于路由协议在网络中的重要地位，因此此研究领域也成为IETF的重要领域。BGP、ISIS、OSPF、MPLS等重要路由协议均属于这个研究领域的研究范围。

> 目前路由研究领域共有14个处于活动状态的工作组。

```
    Border Gateway Multicast Protocol (bgmp) ――边界网关组播协议工作组
    Common Control and Measurement Plane (ccamp) ――通用控制与测量平面工作组
    Forwarding and Control Element Separation (forces) ――控制层与网络层的分离工作组
    Inter-Domain Multicast Routing (idmr) ――域内组播路由工作组
    Inter-Domain Routing (idr) ――域内路由工作组
    IS-IS for IP Internets (isis) ――ISIS路由协议工作组
    Mobile Ad-hoc Networks (manet)
    Multiprotocol Label Switching (mpls) ――MPLS工作组
    Open Shortest Path First IGP (ospf) ――OSPF工作组
    Protocol Independent Multicast (pim) ――PIM工作组
    Routing Protocol Security Requirements (rpsec) ――路由协议的安全需求工作组
    Routing Area Working Group (rtgwg) ――路由域工作组
    Source-Specific Multicast (ssm) ――指定源的组播工作组
    Virtual Router Redundancy Protocol (vrrp) ――虚拟路由冗余协议工作组
```

> 5.6）安全研究领域（sec—Security Area）

> 此研究领域主要负责研究IP网络中的授权、认证、审计等与私密性保护有关的协议与标准。

> 互联网的安全性越来越受到人们的重视，同时AAA与业务的运维方式又有着密切的关系，因此这个领域也成为IETF中最为活跃的研究领域之一。

> 目前，这个研究领域共包括21个处于活动状态的工作组。

```
    Credential and Provisioning (enroll) ――信任与配置工作组
    Intrusion Detection Exchange Format (idwg) ――入侵监测信息交换格式工作组
    Extended Incident Handling (inch) ――扩展的事件处理工作组
    IP Security Protocol (ipsec) ――IPSEC工作组工作组
    IPSEC KEYing information resource record (ipseckey)
    IP Security Policy (ipsp) ――IP安全策略工作组
    Kerberized Internet Negotiation of Keys (kink)
    Kerberos WG (krbwg)
    Long-Term Archive and Notary Services (ltans)
    IKEv2 Mobility and Multihoming (mobike)
    Multicast Security (msec) ――组播安全工作组
    An Open Specification for Pretty Good Privacy (openpgp)
    Profiling Use of PKI in IPSEC (pki4ipsec)
    Public-Key Infrastructure (X.509) (pkix)
    Securely Available Credentials (sacred)
    Simple Authentication and Security Layer (sasl)
    Secure Shell (secsh)
    S/MIME Mail Security (smime)
    Secure Network Time Protocol (stime) ――安全网络时间协议工作组
    Security Issues in Network Event Logging (syslog)
    Transport Layer Security (tls) ――传输层安全工作组
```

> 5.7）传输研究领域（tsv—Transport Area）

> 传输研究领域主要负责研究特殊类型或特殊用途的数据包在网络中的（特殊需求的）传输方式。包括音频/视频数据的传输、拥塞控制、IP性能测量、IP信令系统、IP电话业务、IP存储网络、ENUM、媒体网关、伪线仿真等重要研究方向。

> 目前这个研究领域共有27个处于活动状态的工作组，就工作组数目来讲，是IETF中最大的一个研究领域。

```
    Audio/Video Transport (avt) ――语音/视频传输工作组
    Datagram Congestion Control Protocol (dccp) ――数据报拥塞控制协议工作组
    Telephone Number Mapping (enum) ――ENUM工作组工作组
    Internet Emergency Preparedness (ieprep) ――互联网应急策略工作组
    IP Performance Metrics (ippm) ――IP性能测量工作组
    IP Storage (ips) ――IP存储网工作组
    IP Telephony (iptel) ――IP电话工作组
    Media Gateway Control (megaco) ――媒体控制网关工作组
    Middlebox Communication (midcom)
    Multiparty Multimedia Session Control (mmusic) ――多方多媒体会话控制工作组
    Network File System Version 4 (nfsv4) ――网络文件系统工作组
    Next Steps in Signaling (nsis) ――IP信令的发展工作组
    Path MTU Discovery (pmtud) ――MTU发现协议工作组
    Pseudo Wire Emulation Edge to Edge (pwe3) ――端到端伪线仿真工作组
    Remote Direct Data Placement (rddp)
    Reliable Multicast Transport (rmt) ――可靠的组播传输协议工作组
    Robust Header Compression (rohc) ――可靠的头压缩工作组
    Reliable Server Pooling (rserpool) ――可靠的服务器负载均摊工作组
    Context Transfer, Handoff Candidate Discovery, and Dormant Mode Host Alerting (seamoby)
    Signaling Transport (sigtran) ――信令传输工作组
    Session Initiation Protocol (sip) ――SIP协议工作组
    Session Initiation Proposal Investigation (sipping) ――SIP协议调研工作组
    Speech Services Control (speechsc) ――语音服务控制工作组
    Service in the PSTN/IN Requesting InTernet Service (spirits)
    TCP Maintenance and Minor Extensions (tcpm)
    Transport Area Working Group (tsvwg)――传输领域工作组
    Centralized Conferencing (xcon)――集中控制式会议工作组
```
> 5.8）临时研究领域（sub—Sub-IP Area）
```
    Sub－IP是IETF成立的一个临时技术区域，目前这个研究领域只有一个处于活动状态的工作组，这个工作组主要负责互联网流量工程的研究，已经形成四个RFC。
    Internet Traffic Engineering (tewg)――互联网流量工程工作组
```

### 参考资料 ###
`[1].` http://www.ccsa.org.cn/organization/intro.php?org=IETF<br>
<code>[2].</code> <a href='http://wenku.baidu.com/view/f1da5823bcd126fff7050b53.html?re=view'>http://wenku.baidu.com/view/f1da5823bcd126fff7050b53.html?re=view</a><br>