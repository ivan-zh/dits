package z.ivan.model;

import java.util.Objects;

public class Literature {

    private Long literatureId;
    private String description;
    private Long questionId;


    public Literature() {
    }

    public Long getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Long literatureId) {
        this.literatureId = literatureId;
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
        Literature that = (Literature) o;
        return Objects.equals(literatureId, that.literatureId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literatureId, description, questionId);
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
