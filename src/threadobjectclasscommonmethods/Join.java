package threadobjectclasscommonmethods;

/**
 * @Author: ZHANG
 * @Date: 2019/11/19
 * @Description: main线程等待join的线程执行完毕
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("开始执行子线程");
        thread1.start();
        thread2.start();
        thread1.join();
//        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
