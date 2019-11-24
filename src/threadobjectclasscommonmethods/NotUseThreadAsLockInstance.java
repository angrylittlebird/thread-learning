package threadobjectclasscommonmethods;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description: 之所以不用Thread的实例作为锁的原因就是因为执行完run方法后会自动唤醒thread锁池中的所有线程
 */
public class NotUseThreadAsLockInstance {

    public static void main(String[] args) {
        Thread thread = new Thread(() ->
                System.out.println("线程2执行完毕，自动唤醒thread对象所对应的锁池中的线程")
        );

        new Thread(() -> {
            synchronized (thread) {
                System.out.println("线程1放弃Thread锁");
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1执行完毕");
            }
        }).start();

        thread.start();


    }
}
