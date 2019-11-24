package threadobjectclasscommonmethods;

public class WaitNotifyAll {
    private static Object resourceA = new Object();

    static class WaitThread implements Runnable {
        @Override
        public void run() {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName()+" get resourceA locked");
                System.out.println(Thread.currentThread().getName() + " wait to start");
                try {
                    resourceA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" terminated");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + " get resourceA locked");
                System.out.println(Thread.currentThread().getName() + " notified");
                resourceA.notifyAll();
//                resourceA.notify();
            }
        });

        WaitThread waitThread = new WaitThread();
        Thread thread1 = new Thread(waitThread);
        Thread thread2 = new Thread(waitThread);
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread.start();
    }
}
