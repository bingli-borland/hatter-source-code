
```
function utf8_to_b64( str ) {
    return window.btoa(unescape(encodeURIComponent( str )));
}

function b64_to_utf8( str ) {
    return decodeURIComponent(escape(window.atob( str )));
}

// Usage:
utf8_to_b64('? à la mode'); // "4pyTIMOgIGxhIG1vZGU="
b64_to_utf8('4pyTIMOgIGxhIG1vZGU='); // "? à la mode"
//译者注:在js引擎内部,encodeURIComponent(str)相当于escape(unicodeToUTF8(str))
//所以可以推导出unicodeToUTF8(str)等同于unescape(encodeURIComponent(str))
```


### 参考资料 ###
`[1].` https://developer.mozilla.org/zh-CN/docs/Web/API/Window.btoa<br>