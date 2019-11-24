package uncaughtexception;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description: 子线程在主线程执行过程中抛出，jvm不会退出，并且很难找到堆栈中的异常信息
 */
public class UncaughtChildException implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("子线程抛出了异常");
    }

    public static void main(String[] args) {
        new Thread(new UncaughtChildException()).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
