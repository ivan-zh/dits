package z.ivan.model;

import java.util.Objects;

public class ResultUserStatistic {
    private String question;
    private Boolean correct;
    private String description;
    private String link;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultUserStatistic that = (ResultUserStatistic) o;
        return Objects.equals(question, that.question) &&
                Objects.equals(correct, that.correct) &&
                Objects.equals(description, that.description) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, correct, description, link);
    }

    @Override
    public String toString() {
        return "ResultUserStatistic{" +
                "question='" + question + '\'' +
                ", correct=" + correct +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
