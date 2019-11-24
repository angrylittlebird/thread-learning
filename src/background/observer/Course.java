package background.observer;

import java.util.Observable;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description: 被观察者
 */
public class Course extends Observable {
    private Question question;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void produceQuesion(){
        setChanged();
        notifyObservers(question);
    }
}
