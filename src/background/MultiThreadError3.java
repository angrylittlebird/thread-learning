package background;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 逸出：2    还未完成初始化的操作（构造函数还未执行完毕）就把对象提供给外界
 *                    2.1  构造器中未初始化完毕就this赋值
 */
public class MultiThreadError3 {
    static Test t;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                new Test(1, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"实例化Test类").start();
        Thread.sleep(100); //此时实例化Test类的线程还在阻塞状态还未完成对y的赋值操作
//        Thread.sleep(300);//这里可以看到y已经被赋值了，可以正常打印
        System.out.println(t);
    }
}

class Test {
    private int x;
    private int y;

    public Test(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadError3.t = this;
        Thread.sleep(200);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
