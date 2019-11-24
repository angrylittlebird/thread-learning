package stopthreads;

// 注意try在catch的外面
public class RightWaysStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int n = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && n < 300) {
                    if (n % 100 == 0) {
                        System.out.println(n + "是100的倍数");
                    }
                    n++;
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(111);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();

    }
}
