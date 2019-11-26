package stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//使用一个volatile修饰的变量来中断线程具有局限性，
//譬如当这里的生产者线程阻塞在storage.put()时，程序将不会运行到判断变量canceled代码的位置，因而线程将不会中断。
//可以用interrupt通知中断，
//可以响应中断的会导致的方法 Object wait,Thread sleep,Thread join,BlockingQueue take/put,Lock lockInterruptibly
public class WrongWayVolatileCannotStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(50);
        Producer producer = new Producer(storage);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(1000);


        Consumer consumer = new Consumer(storage);
        while (consumer.isNeedMore()) {
            System.out.println(consumer.getStorage().poll());
        }

        producer.canceled = true;
//        thread.interrupt();
        System.out.println("消费者不需要数据了，中断生产者的线程");

    }
}

class Producer implements Runnable {
    public volatile boolean canceled;
    private BlockingQueue<Integer> storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (!canceled) {
                storage.put(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private BlockingQueue<Integer> storage;

    public BlockingQueue<Integer> getStorage() {
        return storage;
    }

    public Consumer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    public boolean isNeedMore() {
        return Math.random() < 0.95;
    }
}
