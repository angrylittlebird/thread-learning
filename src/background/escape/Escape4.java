package background.escape;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 逸出： 2. 还未完成初始化的操作（构造函数还未执行完毕）就把对象提供给外界
 *                      2.3 构造函数中运行线程
 */
public class Escape4 {
    private Map<Integer, String> map;

    public Escape4() {
        new Thread(() -> {
            this.map = new HashMap<>();
            map.put(1, "星期一");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(2, "星期二");
            map.put(3, "星期三");
            map.put(4, "星期四");
        }).start();
    }

    public String getByNum(Integer num) {
        return map.get(num);
    }

    @Test
    public void initialOperationIsNotCompleted() throws InterruptedException {
        Escape4 escape4 = new Escape4();
        TimeUnit.NANOSECONDS.sleep(1);
        System.out.println(escape4.getByNum(4));
    }

    @Test(expected = NullPointerException.class)
    public void notYetAssigned() {
        Escape4 escape4 = new Escape4();
        System.out.println(escape4.getByNum(4));
    }
}
