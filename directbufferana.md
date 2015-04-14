Usage:
```
wget https://hatter-source-code.googlecode.com/svn/trunk/javatools/directbufferana/directbufferanaall.jar
```
```
$ java -jar directbufferanaall.jar 
[INFO] Add system classloader jar url: /usr/java/jdk1.6.0_25/lib/tools.jar
[INFO] Add system classloader jar url: /usr/java/jdk1.6.0_25/lib/sa-jdi.jar
Usage:
  java -jar directbufferana.jar <PID>
```

Sample:
```
$ java -jar directbufferanaall.jar 19261
[INFO] Add system classloader jar url: /usr/java/jdk1.6.0_25/lib/tools.jar
[INFO] Add system classloader jar url: /usr/java/jdk1.6.0_25/lib/sa-jdi.jar
Attaching to process ID 19261, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 20.0-b11
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
Finding object size using Printezis bits and skipping over...
NIO direct memory: (in bytes)
  reserved size = 128.000000 MB (134217728 bytes)
  max size      = 1996.812500 MB (2093809664 bytes)
  malloc'd size = 256.000000 MB (268435456 bytes)
```


Thanks: https://gist.github.com/1593521