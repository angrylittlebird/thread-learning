package synchronizedemo;

/**
 * @Author: ZHANG
 * @Date: 2019/11/14
 * @Description: 同步代码块
 */
public class SynchronizedDemo1 {
    private static int count = 0;

    static class A implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
