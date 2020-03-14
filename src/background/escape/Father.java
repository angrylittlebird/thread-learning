package background.escape;

/**
 * @Author: ZHANG
 * @Date: 2020/3/14
 * @Description: just to review the interview question.
 */
public class Father {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Father() {
        this.init();
        this.init2();
    }

    public void init() {
        this.a = 10;
    }

    private void init2() {
        this.b = 10;
    }
}

class Sub extends Father {
    public Sub() {
        super();
    }

    public void init() {
    }

    private void init2() {
    }
}

class Test {
    public static void main(String[] args) {
        Father sub = new Sub();
        int a = sub.getA();
        System.out.println(a);
        int b = sub.getB();
        System.out.println(b);
    }
}
