# Introduction #

Show/Set HotSpot system/agent properties.


# Details #

```
wget https://hatter-source-code.googlecode.com/svn/trunk/javatools/jprop/jpropall.jar
```


```
Usage:
  java -jar jpropall.jar [options] <PID>
    <PID>                 target JVM pid
    -show <key name>      filter by key name
    -set <key>=<vlue>     set key & value
    -remove <key>         remove key
    --agent               show agent properties
```

Sample:
Show system properties:
```
$ java -jar jpropall.jar 1808
[INFO] Attach to vm: 1808
[INFO] Detach from vm.
[INFO] Attach to vm: 1808
[INFO] Detach from vm.
java.vm.version                = 20.6-b01-415
java.vendor.url                = http://www.apple.com/
sun.jnu.encoding               = MacRoman
java.vm.info                   = mixed mode
user.dir                       = /Users/hatterjiang/temp
sun.cpu.isalist                = 
java.awt.graphicsenv           = apple.awt.CGraphicsEnvironment
sun.os.patch.level             = unknown
user.home                      = /Users/hatterjiang
java.io.tmpdir                 = /var/folders/w2/w2gVdiT0FDuskYjJDlYx-++++TI/-Tmp-/
java.awt.printerjob            = apple.awt.CPrinterJob
java.version                   = 1.6.0_31
file.encoding.pkg              = sun.io
java.vendor.url.bug            = http://bugreport.apple.com/
mrj.build                      = 10M3635
file.encoding                  = MacRoman
sun.java.command               = T
... ...
```

Show agent properties:
```
$ java -jar jpropall.jar --agent 1808
[INFO] Attach to vm: 1808
[INFO] Detach from vm.
[INFO] Attach to vm: 1808
[INFO] Detach from vm.
sun.java.command               = T
com.sun.management.jmxremote.localConnectorAddress = service:jmx:rmi://127.0.0.1/stub/rO0ABXNyAC5qYXZheC5tYW5hZ2VtZW50LnJlbW90ZS5ybWkuUk1JU2VydmVySW1wbF9TdHViAAAAAAAAAAICAAB4cgAaamF2YS5ybWkuc2VydmVyLlJlbW90ZVN0dWLp/tzJi+FlGgIAAHhyABxqYXZhLnJtaS5zZXJ2ZXIuUmVtb3RlT2JqZWN002G0kQxhMx4DAAB4cHc4AAtVbmljYXN0UmVmMgAADTE5Mi4xNjguMS4xMDEAAMuUdVs+lhPaqoa2zH8pAAABOKcW4YyAAQB4
sun.jvm.args                   = 
sun.jvm.flags                  = 
me.hatter.management.init.Property = true
```