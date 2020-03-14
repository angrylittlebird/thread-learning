#### 演示一些问题

---
##### I.[死锁](DeadLock.java)
解决死锁的方法之一：让任务按照同样的顺序去获取锁。

---
##### II.逸出MultiThreadError2.java
1. 将对象直接返回给外界后，导致状态有可能被外界改变；
解决方法：[返回对象的副本供其它程序读取](escape/Escape2.java)。

2. 由其它线程进行初始化的操作，对象尚未初始化完成：

    2.1 [在构造器中将this赋给其它引用](escape/Escape3.java)
    
    2.2 [其它线程还未完成赋值的操作或初始化的操作未全部完成](escape/Escape4.java)
