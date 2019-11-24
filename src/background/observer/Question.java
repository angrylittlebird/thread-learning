package background.observer;

/**
 * @Author: ZHANG
 * @Date: 2019/11/18
 * @Description:
 */
public class Question {
    private String questionContent;
    /**
     * 提问者姓名
     */
    private String studentName;

    public String getQuestionContent() {
        return questionContent;
    }

    public String getStudentName() {
        return studentName;
    }

    public Question(String questionContent, String studentName) {
        this.questionContent = questionContent;
        this.studentName = studentName;
    }
}
