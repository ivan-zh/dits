package z.ivan.dto;

import z.ivan.model.Question;

import java.util.List;

public class QuestionEditDto {

    private Long id;
    private List<AnswerEditDto> answers;
    private String action;
    private String description;
    private Long testId;

    public Question getQuestion() {
        Question question = new Question();

        question.setQuestionId(id);
        question.setDescription(description);
        question.setTestId(testId);

        return question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AnswerEditDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEditDto> answers) {
        this.answers = answers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
