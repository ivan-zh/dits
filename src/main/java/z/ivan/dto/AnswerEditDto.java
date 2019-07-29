package z.ivan.dto;

import z.ivan.model.Answer;

public class AnswerEditDto {
    private String action;
    private Long id;
    private Boolean correct;
    private String description;
    private Long questionId;


    public Answer getAnswer() {
        Answer answer = new Answer();
        answer.setAnswerId(id);
        answer.setCorrect(correct);
        answer.setDescription(description);
        answer.setQuestionId(questionId);
        return answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
