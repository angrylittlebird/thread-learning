package background.escape;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 逸出：1.方法返回了被private修饰的对象（本意是不想该对象被外部访问）
 */
public class Escape2 {
    private Map<Integer,String> map;

    public Escape2() {
        this.map = new HashMap<>();
        map.put(1, "星期一");
        map.put(2, "星期二");
        map.put(3, "星期三");
        map.put(4, "星期四");
    }

    public Map<Integer,String> getMap(){
        return map;
    }

    //返回一个副本就可以解决上述的逸出问题
    public Map<Integer,String> getMapImproved(){
        return new HashMap<>(map);
    }

    public static void main(String[] args) {
        Escape2 multiThreadError2 = new Escape2();
        Map<Integer, String> map = multiThreadError2.getMap();
        String s = map.get(1);
        System.out.println(s);
        //因为返回了map对象所以导致外部方法可以直接修改该对象
        map.remove(1);
        String s1 = map.get(1);
        System.out.println(s1);


        System.out.println(multiThreadError2.getMapImproved().get(2));
        multiThreadError2.getMapImproved().remove(2);
        System.out.println(multiThreadError2.getMapImproved().get(2));
    }
}
