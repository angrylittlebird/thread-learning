package uncaughtexception;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description: 使用UncaughtExceptionHandler 统一处理子线程中未进行捕获的异常
 */
public class RightWayCaughtChildExceptionRecomended implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException(Thread.currentThread().getName() + "抛出了异常");

    }

    public static void main(String[] args) throws InterruptedException {
        //key
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new RightWayCaughtChildExceptionRecomended(), "线程一").start();
        Thread.sleep(1000);
        new Thread(new RightWayCaughtChildExceptionRecomended(), "线程二").start();
        Thread.sleep(1000);
        new Thread(new RightWayCaughtChildExceptionRecomended(), "线程三").start();
        Thread.sleep(1000);
        new Thread(new RightWayCaughtChildExceptionRecomended(), "线程四").start();
    }
}
