package synchronizedemo.reenter;

/**
 * @Author: ZHANG
 * @Date: 2019/11/16
 * @Description: 可重入：指一个线程的外层函数获得锁之后，内层函数可以直接获取该锁
 *              可重入粒度测试，递归调用本方法
 */
public class SynchronizedRecursion {
    int a = 0;

    public synchronized void method1() {
        System.out.println("a:" + a);
        if (a == 0) {
            a++;
            method1();
        }
    }

    public static void main(String[] args) {
        new SynchronizedRecursion().method1();
    }
}
