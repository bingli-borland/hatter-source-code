# 对称密钥加密 #
|  **算法** | **密钥长度** | **块大小** | **说明** |
|:------------|:-----------------|:--------------|:-----------|
| `DES` | 56 | 64 | Data Encryption Standard |
| `3DES` | 56, 112, 168 | 64 | Triple DES |
| `AES` | 128, 192, 256 | 128 | Advanced Encryption Standard |
| `Twofish` | 128, 192, 256 | 128 | `-` |
| `Blowfish` | 1 ~ 448 | 64 | `-` |
| `IDEA` | 128 | 64 | International Data Encryption Algorithm |
| `RC4` | 4 ~ 2048 | `?` | `-` |
| `RC5` | 4 ~ 2040 | 32, 64, 128 | `-` |
| `RC6` | 128, 192, 256 | 128 | `-` |

# 非对称密钥加密 #
RSA、ElGamal、背包算法、Rabin(Rabin的加密法可以說是RSA方法的特例)、Diffie-Hellman (D-H) 密钥交换协议中的公钥加密算法、Elliptic Curve Cryptography（ECC, 椭圆曲线加密算法）


# SSL工具 #
| `OpenSSL` | http://www.openssl.org/ |OpenSSL: The Open Source toolkit for SSL/TLS |
|:----------|:------------------------|:--------------------------------------------|
| `PolarSSL` | https://polarssl.org/ | SSL Library PolarSSL |
| `CyaSSL` | https://github.com/cyassl/cyassl | CyaSSL is a small, fast, portable implementation of TLS/SSL for embedded devices to the cloud. |
| `LibReSSL` | http://www.libressl.org/ | LibReSSL is a FREE version of the SSL/TLS protocol forked from OpenSSL |
| `BoringSSL` | https://boringssl.googlesource.com/boringssl/ | Boring SSL |


# 相关软件 #
| `TrueCrypt` | http://www.truecrypt.org/ | Free open-source disk encryption software for Windows 7/Vista/XP, Mac OS X, and Linux |
|:------------|:--------------------------|:--------------------------------------------------------------------------------------|
| `TCnext` | https://truecrypt.ch/ | TCnext: Site dedicated to the next "truecrypt" |
| `VeraCrypt` | https://veracrypt.codeplex.com/ | VeraCrypt is a free disk encryption software brought to you by IDRIX (http://www.idrix.fr) and that is based on TrueCrypt. |
| `The GNU Privacy Guard` | http://www.gnupg.org/ | GnuPG is the GNU project's complete and free implementation of the OpenPGP standard as defined by RFC4880 |
| `AxCrypt` | http://www.axantum.com/axcrypt/ | AxCrypt is the leading open source file encryption software for Windows. |
| `Cryptix` | http://www.cryptix.org/ | The Cryptix project: R.I.P. |
| `Bouncy Castle` | http://www.bouncycastle.org/ | The Legion of the Bouncy Castle |
| `FlexiProvider` | http://www.flexiprovider.de/ | The FlexiProvider is a powerful toolkit for the Java Cryptography Architecture (JCA/JCE). |
| `BeeCrypt` | http://beecrypt.sourceforge.net/ | BeeCrypt |

# JavaScript工具 #
| `crypto-js` | https://code.google.com/p/crypto-js/ | JavaScript implementations of standard and secure cryptographic algorithms |
|:------------|:-------------------------------------|:---------------------------------------------------------------------------|
| `jsrsasign` | https://github.com/kjur/jsrsasign | The 'jsrsasign' (RSA-Sign JavaScript Library) is an opensource free cryptography library supporting RSA/RSAPSS/ECDSA/DSA signing/validation, ASN.1, PKCS#1/5/8 private/public key, X.509 certificate, CRL CMS SignedData, TimeStamp and CAdES in pure JavaScript. |
| `gibberish-aes` | https://github.com/mdp/gibberish-aes | A fully OpenSSL compliant javascript library for AES encryption. |
| `AES Advanced Encryption Standard` | http://www.movable-type.co.uk/scripts/aes.html | JavaScript Implementation of AES Advanced Encryption Standard in Counter Mode | Movable Type Scripts |
| `Block TEA (Tiny Encryption Algorithm)` | http://www.movable-type.co.uk/scripts/tea-block.html | JavaScript Implementation of Block TEA Tiny Encryption Algorithm (xxtea) |
| `Cryptico` | https://github.com/wwwtyro/cryptico | An easy-to-use encryption system utilizing RSA and AES for javascript. |
| `OpenPGP.js` | http://openpgpjs.org/ | OpenPGP JavaScript Implementation. |
| `jsbn` | http://www-cs-students.stanford.edu/~tjw/jsbn/ | The jsbn library is a fast, portable implementation of large-number math in pure JavaScript, enabling public-key crypto and other applications on desktop and mobile browsers. |
| `forge` | https://github.com/digitalbazaar/forge | A native implementation of TLS in Javascript and tools to write crypto-based and network-heavy webapps |
| `JavaScript Cryptography Toolkit` | http://ats.oka.nu/titaniumcore/js/crypto/readme.txt | This library is an object oriented cryptography toolkit that implements several fundamental cryptographic algorithms including TWOFISH, SERPENT, RIJNDAEL, RSA with key-generation and SHA(SHA-1,224,256,384,512) for JavaScript. |
| `javascript-rsa` | https://github.com/ziyan/javascript-rsa | RSA encryption with javascript |
| `BitcoinJS` | http://bitcoinjs.org/ | The clean, readable, proven library for Bitcoin JavaScript development. |

# Web工具 #
| `ViaCRYPT` | https://viacry.pt/ | One time read messaging system. [@github](https://github.com/vialink/viacrypt) |
|:-----------|:-------------------|:-------------------------------------------------------------------------------|


# 安全学习 #
| CrypTool | https://www.cryptool.org/ | The CrypTool Portal raises awareness and interest in encryption techniques for everyone. |
|:---------|:--------------------------|:-----------------------------------------------------------------------------------------|

# 其他 #
  * http://www.w3.org/TR/WebCryptoAPI/
  * https://github.com/MaciejCzyzewski/retter

<br>
Related: <a href='Study_Java_Encrypt.md'>Study_Java_Encrypt</a> <a href='Study_Security_Tool_GPG.md'>Study_Security_Tool_GPG</a>

<h3>参考资料</h3>
<code>[1].</code> <a href='http://zh.wikipedia.org/wiki/%E5%AF%B9%E7%A7%B0%E5%AF%86%E9%92%A5%E5%8A%A0%E5%AF%86'>http://zh.wikipedia.org/wiki/%E5%AF%B9%E7%A7%B0%E5%AF%86%E9%92%A5%E5%8A%A0%E5%AF%86</a><br>
<code>[2].</code> <a href='http://en.wikipedia.org/wiki/Symmetric-key_algorithm'>http://en.wikipedia.org/wiki/Symmetric-key_algorithm</a><br>
<code>[3].</code>
<a href='http://zh.wikipedia.org/wiki/%E9%9D%9E%E5%AF%B9%E7%A7%B0%E5%AF%86%E9%92%A5%E5%8A%A0%E5%AF%86'>http://zh.wikipedia.org/wiki/%E9%9D%9E%E5%AF%B9%E7%A7%B0%E5%AF%86%E9%92%A5%E5%8A%A0%E5%AF%86</a><br>
<code>[4].</code> <a href='http://en.wikipedia.org/wiki/Public-key_cryptography'>http://en.wikipedia.org/wiki/Public-key_cryptography</a><br>
<code>[5].</code> <a href='http://en.wikipedia.org/wiki/Transport_Layer_Security'>http://en.wikipedia.org/wiki/Transport_Layer_Security</a><br>
<code>[6].</code> <a href='http://en.wikipedia.org/wiki/CrypTool'>http://en.wikipedia.org/wiki/CrypTool</a><br>