
```
$ ssh -f -N <USER>@<SERVER> -D <PORT>
```

```
var proxyDomainList = [
    "example.com",
    // add more here
    "abcdefghijklmnopqrstuvwxyz.com"
];

var proxyDomainExcludeList = [
    "example.org",
    "1234567890.com"
];

function FindProxyForURL(url, host)
{
    // return "SOCKS5 127.0.0.1:7777";
    // return "DIRECT";
    //*-----------------------------
    for (var i = 0; i < proxyDomainExcludeList.length; i++) {
        var domain = proxyDomainExcludeList[i];
        if (shExpMatch(host, domain)) {
            return "DIRECT";
        }
    }
    //----------------------------*/
    for (var i = 0; i < proxyDomainList.length; i++)
    {
        var domain = proxyDomainList[i];
        if (shExpMatch(host, domain) || shExpMatch(host, "*." + domain))
        {
            return "SOCKS5 127.0.0.1:7777";//; DIRECT";
        }
    }
    return "DIRECT";
}
```


```
$ networksetup -setautoproxyurl Wi-Fi file://localhost/Users/<NAME>/example.pac
```