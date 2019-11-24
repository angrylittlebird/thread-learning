package stopthreads;

/**
 * 传递中断
 */
public class RightWaysStopThreadInProd implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        RightWaysStopThreadInProd wrong = new RightWaysStopThreadInProd();
        Thread thread = new Thread(wrong);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.stop();
    }

    @Override
    public void run() {
        try {
            while (true ) {
                System.out.println("go");
                throwInterrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("log");
        }

    }

    //被线程中的run方法调用的方法必须把异常往外抛
    private void throwInterrupt() throws InterruptedException {
        Thread.sleep(100);
    }
}
