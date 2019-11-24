package threadobjectclasscommonmethods;

/**
 * @Author: ZHANG
 * @Date: 2019/11/19
 * @Description: join后主线程进入Waiting状态，如果此时主线程被中断，应该将中断传递给join的线程，通知join做收尾工作
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                //1.在这里我们用子线程中断主线程
                mainThread.interrupt();

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                //3.
                System.out.println("子线程被中断了");
            }
        });


        System.out.println("开始子线程");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "线程被中断了");
            //2.当主线程被中断，处理中断异常时应该对子线程发起中断，否则会出现数据不一致的情况
            //将中断传递给子线程
            thread.interrupt();
        }

        //4. 中断发生时无法保证这里之后的代码和子线程中的catch里代码的先后顺序
        System.out.println("子线程运行完毕");

    }
}
