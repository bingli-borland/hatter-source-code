
```
sudo openssl req -new -x509 -days 3650 -nodes -out cert.pem -keyout key.pem

* openssl req -new
用 OpenSSL 套件生成新的证书请求
* -x509
使用 X.509（PEM 编码的一种实现）
* -days 3650
有效期是十年，可以自己改
* -nodes
这个不是英文单词 “nodes”，而是 “No DES” 的意思，代表不用 DES 加密私钥，否则私钥默认是用 DES 加密的，每次启动 Apache 要输入密码
* -out
证书（包括证书信息和公钥）的文件名
* -keyout
私钥的文件名，如果此项和上一项同名的话，那么公钥和私钥是合并在同一文件里的（正如上面所贴的）

执行这个命令会让你输入一系列信息，比如 Common Name (CN)、公司名、地理位置、联系方式等，
除了 CN 必须要和网站域名匹配之外，其他可以按照你的喜好自由填写……
```

```
私钥：
openssl genrsa 2048 > ssl.key

* openssl genrsa 2048
显然就是用 OpenSSL 来生成一个 2048 位 RSA 加密的私钥（Generate RSA），这个位数是可以改的
* > ssl.key
这个是通过重定向命令，把生成的东西保存到 ssl.key 这个文件中。我的文件命名习惯上面提过了……

生成证书请求的命令是这个：
openssl req -new -key ssl.key > ssl.csr
```


```
DER 是內容為二進位碼的證書，而 PEM 則是 Base64 編碼加上特定檔頭的證書。 這兩者可以互轉。

openssl x509 -in x509.crt -inform DER -out x509.pem -outform PEM

openssl x509 -text -in mycert.pem
```


OpenSSL Command-Line HOWTO:
```
http://www.madboa.com/geek/openssl/
```


```
openssl s_client -connect <IP or HOST>:443
```

取得证书信息：
```
#!/bin/sh
#
# usage: retrieve_cert.sh host [port]
#
REMHOST=$1
REMPORT=${2:-443}

echo |\
openssl s_client -connect ${REMHOST}:${REMPORT} 2>&1 |\
sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p'
```

取得证书链信息：
```
#!/bin/sh
#
# usage: cert_chain.sh host [port]
#
REMHOST=$1
REMPORT=${2:-443}

echo |\
openssl s_client -connect ${REMHOST}:${REMPORT} 2>&1 |\
sed -ne '/Certificate chain/,/---/p'
```

### 参考资料 ###
`[1].` https://www.openssl.org/docs/apps/x509.html<br>
<code>[2].</code> <a href='https://www.openssl.org/docs/apps/s_client.html'>https://www.openssl.org/docs/apps/s_client.html</a><br>