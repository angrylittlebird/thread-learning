package uncaughtexception;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description:
 */
public class RightWayCaughtChildException implements Runnable {
    @Override
    public void run() {
        try {
            throw new RuntimeException(Thread.currentThread().getName() + "抛出了异常");
        }catch (Exception e){
            System.out.println("异常被捕获");
        }
    }

    public static void main(String[] args) throws InterruptedException {
            new Thread(new RightWayCaughtChildException(),"线程一").start();
            Thread.sleep(1000);
            new Thread(new RightWayCaughtChildException(),"线程二").start();
            Thread.sleep(1000);
            new Thread(new RightWayCaughtChildException(),"线程三").start();
            Thread.sleep(1000);
            new Thread(new RightWayCaughtChildException(),"线程四").start();
    }
}
