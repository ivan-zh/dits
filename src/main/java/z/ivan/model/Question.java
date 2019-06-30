package z.ivan.model;

import java.util.Objects;

public class Question {

    private Long questionId;
    private String description;
    private Long testId;

    public Question() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionId, question.questionId) &&
                Objects.equals(description, question.description) &&
                Objects.equals(testId, question.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, description, testId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", testId=" + testId +
                '}';
    }
}
