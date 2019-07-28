package z.ivan.dto;

import z.ivan.model.Answer;

public class AnswerEditDto {
    private Answer answer;
    private String action;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
