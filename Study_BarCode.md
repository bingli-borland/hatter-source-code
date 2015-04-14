http://barcode-coder.com/en/

# 一维码 #
条形码或稱条码（barcode）是将宽度不等的多个黑条和空白，按照一定的编码规则排列，用以表达一组信息的图形标识符。

# 二维码 #

| **Name** | **Developer(country)** | **Type** | **Main usages** |
|:---------|:-----------------------|:---------|:----------------|
| QR Code | DENSO(Japan) | Matrix | All categories |
| PDF417 | Symbol Technologies (USA) | Stacked Bar Code | OA |
| DataMatrix | RVSI Acuity CiMatrix (USA) | Matrix | FA |
| Maxi Code | UPS (USA) | Matrix | Logistics |

## QR Code ##
[QRcode.com](http://www.qrcode.com/en/index.html)

<table border='1'>
<tr><td align='center'><b>QR碼資料容量</b></td></tr>
<tr><td>數字</td><td>最多7,089字元</td></tr>
<tr><td>字母</td><td>最多4,296字元</td></tr>
<tr><td>二進位數（8 bit）</td><td>最多2,953 位元組</td></tr>
<tr><td>日文漢字／片假名</td><td>最多1,817字元（採用Shift JIS）</td></tr>
<tr><td>中文漢字</td><td>最多984字元（採用UTF-8）</td></tr>
<tr><td>中文漢字</td><td>最多1,800字元（採用BIG5）</td></tr>
</table>

<table border='1'>
<tr><td align='center'><b>錯誤修正容量</b></td></tr>
<tr><td>L水平</td><td>7%的字碼可被修正</td></tr>
<tr><td>M水平</td><td>15%的字碼可被修正</td></tr>
<tr><td>Q水平</td><td>25%的字碼可被修正</td></tr>
<tr><td>H水平</td><td>30%的字碼可被修正</td></tr>
</table>

## Barcode Contents <sup>[4]</sup> ##
| **Type** | **Sample** |
|:---------|:-----------|
| URL | `http://hatter.me` |
| E-mail address | `mailto:mail@example.com` |
| Telephone numbers | `tel:12345678` |
| vCard | `-` |
| AU format | `-` |
| meCard | `MECARD:N:name;ADR:  ;TEL: 12345678;EMAIL: mail@example.com;URL: http://www.example.com;;` |
| BIZCARD | `-` |
| SMS | `smsto:12345678:text` |
| MMS | `-`  |
| Geographic information | `geo:111111,222222` |
| Android Market | `market://details?id=appname` |
| Wifi Network config | `WIFI:S:ssid;T:WEP;P:password;;` |
| iCal | `-` |

QR生成或读取:
  * Google ZXing: https://code.google.com/p/zxing/
  * Google QR Code API: https://google-developers.appspot.com/chart/infographics/docs/qr_codes

JS QR:
  * http://d-project.googlecode.com/svn/trunk/misc/qrcode/index.html
  * https://github.com/jeromeetienne/jquery-qrcode
  * https://code.google.com/p/jsqrencode/
  * https://github.com/yyx990803/QR.js

QR应用：
  * Google Authenticator: https://code.google.com/p/google-authenticator/


<sup>注</sup> QR Code is registered trademark of DENSO WAVE INCORPORATED.

### 参考资料 ###
`[1].` http://zh.wikipedia.org/wiki/QR%E7%A2%BC<br>
<code>[2].</code> <a href='http://www.qrcode.com/en/aboutqr.html'>http://www.qrcode.com/en/aboutqr.html</a><br>
<code>[3].</code> <a href='http://zh.wikipedia.org/wiki/%E6%9D%A1%E5%BD%A2%E7%A0%81'>http://zh.wikipedia.org/wiki/%E6%9D%A1%E5%BD%A2%E7%A0%81</a><br>
<code>[4].</code> <a href='http://code.google.com/p/zxing/wiki/BarcodeContents'>http://code.google.com/p/zxing/wiki/BarcodeContents</a><br>