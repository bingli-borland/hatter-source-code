AES（Advanced Encryption Standard，高级加密标准）又叫Rijndael加密法，用来替代DES算法。常见AES加密模式有ECB、CBC、CFB、OFB和CTR等五种， CFB、OFB都带反馈，做流加密用的多，CBC和CTR、ECB多用于独立block加密，由于ECB算法有点小缺点（相同输入，相同输出，容易明文攻击），所以CBC和CTR这两种加解密方式用的较多，也是很多标准规范要求的实现算法，下面看一下这两种算法原理。

AES跟Rijndael相比有点小区别，就是使用固定块（block size）为128bits（16字节）（原Rijndael块大小更灵活），密钥长度支持128、192或256位。

  * CBC加密原理：
> 明文跟向量异或，再用KEY进行加密，结果作为下个BLOCK的初始化向量。解密原理：使用密钥先对密文解密，解密后再同初始向量异或得到明文。
> CBC需要对明文块大小进行Padding（补位），由于前后加密的相关性，只能实施串行化动作，无法并行运算。另外，CBC需要参量：密钥和初始化向量。

  * CTR加密原理：
> 用密钥对输入的计数器加密，然后同明文异或得到密文。解密原理：用密钥对输入计数器加密，然后同密文异或得到明文。
> CTR不需要Padding，而且采用了流密钥方式加解密，适合于并行运算，CTR涉及参量：Nounce随机数、Counter计数器和密钥。Nounce随机数和Counter计数器整体可看作计数器，因为只要算法约定好，就可以回避掉串行化运算。

JCE中AES支持五中模式：CBC，CFB，ECB，OFB，PCBC；支持三种填充：NoPadding，PKCS5Padding，ISO10126Padding。不支持SSL3Padding。不支持“NONE”模式。不带模式和填充来获取AES算法的时候，其默认使用ECB/PKCS5Padding。


| **算法/模式/填充** | **16字节加密后数据长度** | **不满16字节加密后长度** |
|:-------------------------|:----------------------------------|:----------------------------------|
| `AES/CBC/NoPadding`       |      16               |          不支持 |
| `AES/CBC/PKCS5Padding`      |    32               |          16 |
| `AES/CBC/ISO10126Padding`  |     32             |             16 |
| `AES/CFB/NoPadding`        |     16                |          原始数据长度 |
| `AES/CFB/PKCS5Padding`   |       32               |           16 |
| `AES/CFB/ISO10126Padding`  |     32              |            16 |
| `AES/ECB/NoPadding`    |         16                |          不支持 |
| `AES/ECB/PKCS5Padding`     |     32                |          16 |
| `AES/ECB/ISO10126Padding`  |     32               |           16 |
| `AES/OFB/NoPadding`     |        16                 |         原始数据长度 |
| `AES/OFB/PKCS5Padding`    |      32            |              16 |
| `AES/OFB/ISO10126Padding`   |    32                 |         16 |
| `AES/PCBC/NoPadding`     |       16                  |        不支持 |
| `AES/PCBC/PKCS5Padding`     |    32              |            16 |
| `AES/PCBC/ISO10126Padding`    |  32              |            16 |

### 参考资料 ###
`[1].` http://www.metsky.com/archives/585.html<br>
<code>[2].</code> <a href='http://blog.sina.com.cn/s/blog_679daa6b0100zmpp.html'>http://blog.sina.com.cn/s/blog_679daa6b0100zmpp.html</a><br>
<code>[3].</code> <a href='http://en.wikipedia.org/wiki/Block_cipher_modes_of_operation'>http://en.wikipedia.org/wiki/Block_cipher_modes_of_operation</a><br>