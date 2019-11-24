package uncaughtexception;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description: try-catch只能捕获当前线程中的异常，主线程中使用try-catch并不能捕获子线程的异常
 */
public class WrongWayCaughtChildException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("子线程抛出了异常");
    }

    public static void main(String[] args) {
        try {
            new Thread(new WrongWayCaughtChildException(),"线程一").start();
            Thread.sleep(1000);
            new Thread(new WrongWayCaughtChildException(),"线程二").start();
            Thread.sleep(1000);
            new Thread(new WrongWayCaughtChildException(),"线程三").start();
            Thread.sleep(1000);
            new Thread(new WrongWayCaughtChildException(),"线程四").start();

        }catch (Exception e){
            //并不能打印下面的语句
            System.out.println("异常被捕获");
        }
    }
}
