package z.ivan.model;

import java.util.Objects;

public class Answer {

    private Long answerId;
    private String description;
    private Long questionId;

    public Answer() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer question = (Answer) o;
        return Objects.equals(answerId, question.answerId) &&
                Objects.equals(description, question.description) &&
                Objects.equals(questionId, question.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, description, questionId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "answerId=" + answerId +
                ", description='" + description + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
