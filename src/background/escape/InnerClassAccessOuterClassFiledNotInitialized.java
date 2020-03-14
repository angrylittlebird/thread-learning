package background.escape;

/**
 * @Author: ZHANG
 * @Date: 2020/3/14
 * @Description: 内部类访问到外部类未初始化完成的成员变量
 */
public class InnerClassAccessOuterClassFiledNotInitialized {
    private int thisCanBeEscape;
    public InnerClassAccessOuterClassFiledNotInitialized(){
        new InnerClass();
        thisCanBeEscape = 2;
    }
    private class InnerClass {
        public InnerClass() {
            //这里可以在Escape对象完成构造前提前引用到Escape的private变量
            System.out.println(InnerClassAccessOuterClassFiledNotInitialized.this.thisCanBeEscape);
        }
    }
    public static void main(String[] args) {
        new InnerClassAccessOuterClassFiledNotInitialized();
    }
}
