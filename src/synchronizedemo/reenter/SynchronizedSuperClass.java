package synchronizedemo.reenter;

/**
 * @Author: ZHANG
 * @Date: 2019/11/16
 * @Description:              可重入粒度测试: 可以不是同一个类中的方法
 */
public class SynchronizedSuperClass {
    public void doSomething(){
        synchronized (this) {
            System.out.println("我是父类方法");
        }
    }
}

class TestClass extends SynchronizedSuperClass{
    public synchronized void doSomething(){
        System.out.println("我是子类的方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        new TestClass().doSomething();
    }
}
