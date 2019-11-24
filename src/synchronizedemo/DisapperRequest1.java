package synchronizedemo;

/**
 * @Author: ZHANG
 * @Date: 2019/11/14
 * @Description: 证明i++是非原子性操作
 */
public class DisapperRequest1 {
    static int i = 0;

    static class Request1 implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Request1 request1 = new Request1();
        Thread thread1 = new Thread(request1);
        Thread thread2 = new Thread(request1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
