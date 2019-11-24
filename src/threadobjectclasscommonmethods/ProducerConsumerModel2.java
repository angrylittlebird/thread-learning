package threadobjectclasscommonmethods;

import java.util.ArrayList;
import java.util.List;

//设计一个自己的阻塞队列，当队列满了调用offer方法的线程阻塞或者队列为空时调用take方法的线程阻塞
public class ProducerConsumerModel2 {
    static class MyBlockQueue{
        private int maxsize;
        private List<Integer> list;

        public MyBlockQueue(int maxsize) {
            this.maxsize = maxsize;
            this.list = new ArrayList<>();
        }

        public void offer(int num){
            //1.判断对列是否已满，满了则释放锁，未满则加入队列
            if (list.size() < maxsize) {
                list.add(num);
            }
        }
    }
}
