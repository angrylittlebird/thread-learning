package background.observer;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 让多个观察者同时监听某一个主题对象，当主题对象发生变化时，它的所有观察者都会收到通知并更新
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course("设计模式");
        Teacher teacher1 = new Teacher("Alpha");
        Teacher teacher2 = new Teacher("Beta");
        course.addObserver(teacher1);
        course.addObserver(teacher2);

        //业务逻辑
        Question question = new Question("如何调用主函数", "geely");
        course.setQuestion(question);
        course.produceQuesion();
    }
}
