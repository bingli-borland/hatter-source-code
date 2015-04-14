http://www.html5rocks.com/en/resources

http://slides.html5rocks.com/



> The ZeroClipboard library provides an easy way to copy text to the clipboard using an invisible Adobe Flash movie and a JavaScript interface.
> http://zeroclipboard.org/

  * Full Screen
```
// Find the right method, call on correct element
function launchFullScreen(element) {
  if(element.requestFullScreen) {
    element.requestFullScreen();
  } else if(element.mozRequestFullScreen) {
    element.mozRequestFullScreen();
  } else if(element.webkitRequestFullScreen) {
    element.webkitRequestFullScreen();
  }
}

// Whack fullscreen
function cancelFullscreen() {
  if(document.cancelFullScreen) {
    document.cancelFullScreen();
  } else if(document.mozCancelFullScreen) {
    document.mozCancelFullScreen();
  } else if(document.webkitCancelFullScreen) {
    document.webkitCancelFullScreen();
  }
}

// document.fullScreenElement: the element which has been pushed to fullscreen.
var fullscreenElement = document.fullScreenElement || document.mozFullScreenElement || document.webkitFullScreenElement;
// document.fullScreenEnabled:  notes if fullscreen is current enabled.
var fullscreenEnabled = document.fullScreenEnabled || document.mozScreenEnabled || document.webkitScreenEnabled;

// CSS
/* html */
:-webkit-full-screen {
  background: pink;
}
:-moz-full-screen {
  background: pink;
}
```

### 参考资料 ###
`[1].` http://davidwalsh.name/fullscreen<br>