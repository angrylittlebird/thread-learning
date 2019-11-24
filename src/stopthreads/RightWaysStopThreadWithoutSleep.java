package stopthreads;

/**
 * 没有sleep,wait的条件下停止线程
 */
public class RightWaysStopThreadWithoutSleep implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWaysStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 1;
        while (!Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE / 2) {
            if (num % 100000 == 0) {
                System.out.println(num + "是100000的倍数");
            }
            num++;
        }
    }
}
