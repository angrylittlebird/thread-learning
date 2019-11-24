package stopthreads;

/**
 * 恢复中断
 */
public class RightWaysStopThreadInProd2 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        RightWaysStopThreadInProd2 wrong = new RightWaysStopThreadInProd2();
        Thread thread = new Thread(wrong);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("程度被中断了");
                break;
            }
            reInterrupt();
        }


    }

    //被线程中的run方法调用的方法必须把异常往外抛
    private void reInterrupt() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
