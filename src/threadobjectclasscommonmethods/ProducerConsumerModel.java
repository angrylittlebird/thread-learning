package threadobjectclasscommonmethods;

import java.util.ArrayList;

public class ProducerConsumerModel {

    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        new Thread(new ProducerThread(doubles)).start();
        new Thread(new ConsumerThread(doubles)).start();
    }

    static class ProducerThread implements Runnable{
        ArrayList list;

        public ProducerThread(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() < 5) {
                        list.add(Math.random());
                    }
                    System.out.println(list);
                    list.notify();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ConsumerThread implements Runnable{
        ArrayList list;

        public ConsumerThread(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() > 0) {
                        System.out.println(list.remove(0));
                    }
                    list.notify();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
