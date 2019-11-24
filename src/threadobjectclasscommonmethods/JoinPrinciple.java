package threadobjectclasscommonmethods;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description:
 */
public class JoinPrinciple {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行完毕");
        });

        thread.start();
//        thread.join();
        //等价转换
        synchronized (thread){
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕");
    }
}
