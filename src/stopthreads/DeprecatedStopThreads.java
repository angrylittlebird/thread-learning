package stopthreads;

//stop,suspend,resume
public class DeprecatedStopThreads implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取装备");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "领取装备完毕");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeprecatedStopThreads());
        thread.start();
        Thread.sleep(1000);
        //突然的中断线程会是线程无法完成一个基本单位的操作
        //stop方法会释放所有已锁定的监视器（causes it to unlock all of the monitors that it has locked）
        thread.stop();
    }
}
