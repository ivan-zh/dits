package z.ivan.model;

import java.util.Objects;

public class QuestionStatistics {

    private String name;
    private int count;
    private float avg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionStatistics that = (QuestionStatistics) o;
        return count == that.count &&
                Float.compare(that.avg, avg) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, avg);
    }

    @Override
    public String toString() {
        return "QuestionStatistics{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", avg=" + avg +
                '}';
    }
}
