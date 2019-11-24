package stopthreads;

//run方法执行过程中，每次循环都会调用sleep,wait等方法，则不要每次迭代都检查是否被通知中断信号
public class RightWaysStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int n = 0;
            try {
                while (n < 3000) {
                    if (n % 100 == 0) {
                        System.out.println(n + "是100的倍数");
                    }
                    n++;
                    Thread.sleep(10);
                }
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
