package synchronizedemo.reenter;

/**
 * @Author: ZHANG
 * @Date: 2019/11/16
 * @Description: 可重入：指一个线程的外层函数获得锁之后，内层函数可以直接获取该锁
 *              可重入粒度测试：可重入不要求是同一个方法
 */
public class SynchronizedOtherMethod {

    public synchronized void method1() {
        System.out.println("a");
        method2();
        System.out.println("c");
    }

    public synchronized void method2() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        new SynchronizedOtherMethod().method1();
    }
}
