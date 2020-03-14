package background;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 线程安全问题：演示死锁
 */
public class DeadLock implements Runnable{
    private int a = 0;
    //注意这里的static 保证了所有MultiThreadError实例用的都是同一把锁
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    @Override
    public void run() {
        System.out.println("a: " + a);
        if (a == 0) {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName()+" get lock1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName()+ " get lock2");
                }
            }
        }

        if (a == 1) {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+" get lock2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+ " get lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock threadError1 = new DeadLock();
        DeadLock threadError2 = new DeadLock();
        threadError2.a = 1;
        new Thread(threadError1).start();
        new Thread(threadError2).start();
    }
}
