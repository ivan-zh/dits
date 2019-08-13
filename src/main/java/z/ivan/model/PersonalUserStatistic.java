package z.ivan.model;

import java.util.Objects;

public class PersonalUserStatistic {
    private String firstName;
    private String lastName;
    private String name;
    private String question;
    private int count;
    private float avg;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public float getAvg() { return avg; }

    public void setAvg(float avg) { this.avg = avg; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalUserStatistic that = (PersonalUserStatistic) o;
        return count == that.count &&
                Float.compare(that.avg, avg) == 0 &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, name, question, count, avg);
    }

    @Override
    public String toString() {
        return "PersonalUserStatistic{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", question='" + question + '\'' +
                ", count=" + count +
                ", avg=" + avg +
                '}';
    }
}
