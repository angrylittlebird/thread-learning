package threadobjectclasscommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZHANG
 * @Date: 2019/11/19
 * @Description: sleep较为优雅的写法
 */
public class SleepInterrupted implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                System.out.println(new Date());
                //key：会休眠61秒
                TimeUnit.MINUTES.sleep(1);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("当前线程在阻塞状态下中断");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();
    }
}
