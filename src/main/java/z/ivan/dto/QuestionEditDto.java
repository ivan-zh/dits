package z.ivan.dto;

import z.ivan.model.Question;

public class QuestionEditDto {
    private Question question;
    private String action;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
