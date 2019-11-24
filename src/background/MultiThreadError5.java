package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 逸出： 2. 还未完成初始化的操作（构造函数还未执行完毕）就把对象提供给外界
 *                     2.3 构造函数中运行线程
 */
public class MultiThreadError5 {
    private Map<Integer,String> map;

    public MultiThreadError5() {
        new Thread(()->{
            this.map = new HashMap<>();
            map.put(1, "星期一");
            map.put(2, "星期二");
            map.put(3, "星期三");
            map.put(4, "星期四");
        }).start();
    }

    public String getByNum(Integer num){
        return map.get(num);
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadError5 multiThreadError5 = new MultiThreadError5();
//        Thread.sleep(1000);
        System.out.println(multiThreadError5.getByNum(1));
    }
}
