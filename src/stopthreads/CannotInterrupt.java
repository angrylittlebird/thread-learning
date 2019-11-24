package stopthreads;

//try 在 catch 的里面
public class CannotInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int n = 0;
            while (n < 3000 && !Thread.currentThread().isInterrupted()) {
                if (n % 100 == 0) {
                    System.out.println(n + "是100的倍数");
                }
                n++;

                try {
                    //sleep一旦响应中断就会把interrupt标记为清除掉
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
