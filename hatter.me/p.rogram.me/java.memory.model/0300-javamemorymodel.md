!!EXPLAIN
Java内存模型

我们先来看一段代码：

%%% prettify ln=1
final class SetCheck {
  private int  a = 0;
  private long b = 0;

  void set() {
    a =  1;
    b = -1;
  }

  boolean check() {
    return ((b ==  0) ||
            (b == -1 && a == 1)); 
  }
}
%%%

_代码引用自：[!](http://gee.cs.oswego.edu/dl/cpj/jmm.html)_

逻辑上来讲，因为`a = 1`早于`b = -1`，所以`check()`函数返回必定为`true`，但实际情况却未必如此，在某些特殊的场景下(如并发场景下在特殊的微架构平台上)可能会返回`false`。需要解决这一类问题，Java才引入了Java内存模型。


!!#mainmemandworkmem# 内存模型

<img src="jmm.png"/>

### 原子性

某些指令的执行是需要有不可分割的效果的（执行不可打断）。为了这样的模型，该规则仅用于简单的读、写内存单元，包含了实例及静态字段（当然也包含数组元素），但不包含在函数中的局部变量。

### 可见性

在一个线程写入变量后另外一个线程需要对该变化可见。效果是当一个线程写入一个字段后，另外一个线程需要对这个字段可见（写入的最新值）。

> ### happen-before
> 
> 1. 同一个线程中的每个`Action`都`happens-before`于出现在其后的任何一个`Action`。
> 1. 对一个监视器的解锁`happens-before`于每一个后续对同一个监视器的加锁。
> 1. 对`volatile`字段的写入操作`happens-before`于每一个后续的同一个字段的读操作。
> 1. `Thread.start()`的调用会`happens-before`于启动线程里面的动作。
> 1. `Thread`中的所有动作都`happens-before`于其他线程检查到此线程结束或者`Thread.join()`中返回或者`Thread.isAlive()==false`。
> 1. 一个线程`A`调用另一个另一个线程B的`interrupt()`都`happens-before`于线程`A`发现`B`被`A`中断（`B`抛出异常或者`A`检测到`B`的`isInterrupted()`或者`> interrupted()`）。
> 1. 一个对象构造函数的结束`happens-before`与该对象的`finalizer`的开始
> 1. 如果A动作`happens-before`于`B`动作，而B动作`happens-before`与`C`动作，那么`A`动作`happens-before`于`C`动作。

### 重排序

任意一个线程都可能表现的乱序执行。而排序问题也总是围绕赋值语句的读、写顺序。


!!#final# final

一个对象的`final`字段值是在它的构造方法里面设置的。假设对象被正确的构造了，一旦对象被构造，在构造方法里面设置给`final`字段的的值在没有同步的情况下对所有其他的线程都会可见。另外，引用这些`final`字段的对象或数组都将会看到`final`字段的最新值。

```
class FinalFieldExample {
  final int x;
  int y;
  static FinalFieldExample f;
  public FinalFieldExample() {
    x = 3;
    y = 4;
  }

  static void writer() {
    f = new FinalFieldExample();
  }

  static void reader() {
    if (f != null) {
      int i = f.x; // <---- 能读到x的正确值：3
      int j = f.y; // <---- 不一定能读到y的正确值：4
    }
  }
}
```

```
public FinalFieldExample() { // bad!
  x = 3;
  y = 4;
  // bad construction - allowing this to escape
  global.obj = this; // <---- 在这里外部程序也未必能够看到x的正确值：3
}
```

<br>
_代码引用自：http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html_


!!#volatile# volatile

`volatile`关键词是告诉编译器说“这个变量是易变的，请保证始终读、写唯一的值，并且请保证原子性”，当编译器接收到这些信息后，编译器会做如下处理：

1. 禁止编译器本身对该变量的读、写缓存优化
1. 根据当前的微架构，在生成读、写该变量的硬件指令时禁止CPU的高速缓存
    * `X86`：微架构已经保证了缓存的强一致性，无须使用特别的指令
    * `IA64`：使用`ld.acq`或`st.rel`指令进行读、写，保证CPU的高速缓存被更新
1. 禁止对这个变量读写前后的指令重排
    * `X86`：`mfence` or `cpuid` or `locked insn` (`lock; addl $0,0(%%esp)`)
    * `IA64`：`mf`

对于原子性、可见性和重排序来说，定义一个`volatile`的字段的作用等价于下面这样的类（定义一个`synchronized`保护的使用`get`/`set`方法访问的类）：

%%% prettify ln=1
final class VFloat {
  private float value;

  final synchronized void  set(float f) { value = f; }
  final synchronized float get()        { return value; }
}
%%%

<br>
_代码引用自：http://gee.cs.oswego.edu/dl/cpj/jmm.html_

!!#synchronized# synchronized


`synchronized`的锁原理及优化详见：[!Study_Java_HotSpot_Concurrent](https://code.google.com/p/hatter-source-code/wiki/Study_Java_HotSpot_Concurrent)

!!#contended# @Contended

<span class="glyphicon glyphicon-thumbs-down" style="color:red;"></span> `sun.misc.Contended`

`@Contended`通过[!JEP 142 (在特定字段上减少高速缓存竞争访问)](http://openjdk.java.net/jeps/142)引入，即针对伪共享提供一种解决方案，解决方法是通过`@Contended`来标记哪些字段是竞争访问的，编译器在编译的时候即将存在竞争访问的字段对齐到不同的缓存线。

Sample代码`jdk/src/share/classes/java/lang/Thread.java`：
%%% prettify
2034     // The following three initially uninitialized fields are exclusively
2035     // managed by class java.util.concurrent.ThreadLocalRandom. Additionally,
2036     // these fields are isolated from other fields in Thread due to being
2037     // heavily updated.
2038     /** The current seed for a ThreadLocalRandom */
2039     @sun.misc.Contended("tlr")
2040     long threadLocalRandomSeed;
2041     /** Probe hash value; nonzero if threadLocalRandomSeed initialized */
2042     @sun.misc.Contended("tlr")
2043     int threadLocalRandomProbe;
2044     /** Secondary seed isolated from public ThreadLocalRandom sequence */
2045     @sun.misc.Contended("tlr")
2046     int threadLocalRandomSecondarySeed;
%%%



