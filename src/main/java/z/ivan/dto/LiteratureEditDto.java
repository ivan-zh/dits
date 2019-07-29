package z.ivan.dto;

import z.ivan.model.Literature;

import java.util.List;

public class LiteratureEditDto {
    private Long id;
    private String description;
    private Long questionId;
    private String action;
    private List<LinkEditDto> links;

    public void setAction(String action) {
        this.action = action;
    }

    public List<LinkEditDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkEditDto> links) {
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Literature getLiterature() {
        Literature literature = new Literature();
        literature.setLiteratureId(id);
        literature.setDescription(description);
        literature.setQuestionId(questionId);
        return literature;
    }

    public String getAction() {
        return action;
    }
}
