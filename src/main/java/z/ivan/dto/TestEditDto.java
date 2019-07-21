package z.ivan.dto;

import z.ivan.model.Test;

public class TestEditDto {

    private Long id;
    private Long topicId;
    private String name;
    private String description;
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Test toEntity() {
        Test t = new Test();
        t.setTestId(id);
        t.setName(name);
        t.setDescription(description);
        t.setTopicId(topicId);
        return t;
    }
}
