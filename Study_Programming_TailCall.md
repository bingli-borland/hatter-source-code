尾调用是指一个函数里的最后一个动作是一个函数调用的情形：即这个调用的返回值直接被当前函数返回的情形。这种情形下称该调用位置为尾位置。若这个函数在尾位置调用本身（或是一个尾调用本身的其他函数等等），则称这种情况为尾递归，是递归的一种特殊情形。尾调用不一定是递归调用，但是尾递归特别有用，也比较容易实现。

尾调用的重要性在于它可以不在调用栈上面添加一个新的堆栈帧——而是更新它，如同迭代一般。尾递归因而具有两个特征：
  * 调用自身函数(Self-called)；
  * 计算仅占用常量栈空间(Stack Space)。

http://wiki.jvmlangsummit.com/Why_Tailcalls

http://www.oracle.com/technetwork/java/javase/gc-tuning-6-140523.html#cms.floating_garbage

### 参考资料 ###
`[1].` http://zh.wikipedia.org/wiki/%E5%B0%BE%E8%B0%83%E7%94%A8<br>
<code>[2].</code> <a href='http://ssw.jku.at/Research/Papers/Schwaighofer09Master/schwaighofer09master.pdf'>http://ssw.jku.at/Research/Papers/Schwaighofer09Master/schwaighofer09master.pdf</a><br>