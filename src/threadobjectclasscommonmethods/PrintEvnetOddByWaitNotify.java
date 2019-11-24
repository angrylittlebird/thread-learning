package threadobjectclasscommonmethods;

public class PrintEvnetOddByWaitNotify {
    private static int count = 0;
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintEvent(), "偶数").start();
        Thread.sleep(100);
        new Thread(new PrintEvent(), "奇数").start();
    }

    static class PrintEvent implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    object.notify();

                    if (count <= 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}
