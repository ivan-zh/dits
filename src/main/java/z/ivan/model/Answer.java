package z.ivan.model;

import java.util.Objects;

public class Answer {

    private Long answerId;
    private String description;
    private Long questionId;
    private Boolean correct;

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

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answerId, answer.answerId) &&
                Objects.equals(description, answer.description) &&
                Objects.equals(questionId, answer.questionId) &&
                Objects.equals(correct, answer.correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, description, questionId, correct);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", description='" + description + '\'' +
                ", questionId=" + questionId +
                ", correct=" + correct +
                '}';
    }
}
