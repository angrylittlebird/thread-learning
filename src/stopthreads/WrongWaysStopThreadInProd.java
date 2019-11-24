package stopthreads;

public class WrongWaysStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            throwInProd();
        }
    }

    //被线程中的run方法调用的方法没有把异常往外抛
    private void throwInProd(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();//中断被吞掉了
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWaysStopThreadInProd wrong = new WrongWaysStopThreadInProd();
        Thread thread = new Thread(wrong);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
