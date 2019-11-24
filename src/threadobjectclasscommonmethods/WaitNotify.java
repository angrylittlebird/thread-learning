package threadobjectclasscommonmethods;

/**
 * 验证执行的顺序
 */
public class WaitNotify {
    private static Object object = new Object();
    static class WaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"获得了锁");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        }
    }

    static class NotifyThread implements Runnable{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"获得了锁");
                object.notify();
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitThread()).start();
        Thread.sleep(200);
        new Thread(new NotifyThread()).start();
    }
}
