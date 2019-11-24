package background.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description:
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        Course c = (Course) o;
        Question q = (Question) arg;

        System.out.println(q.getStudentName()+ "在" + name + "老师的课程:" + c.getCourseName() + "中提了一个问题：" + q.getQuestionContent());

        //key!!!当update方法中并发过高时则需要通过消息队列或者其它异步的手段来改成异步的
    }
}
