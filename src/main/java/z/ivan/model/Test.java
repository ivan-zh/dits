package z.ivan.model;

import java.util.Objects;

public class Test {

    private Long testId;
    private String name;
    private String description;
    private Long topicId;

    public Test() {
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testId, test.testId) &&
                Objects.equals(name, test.name) &&
                Objects.equals(description, test.description) &&
                Objects.equals(topicId, test.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, name, description, topicId);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topicId=" + topicId +
                '}';
    }

}
