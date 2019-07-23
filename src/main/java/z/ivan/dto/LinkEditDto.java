package z.ivan.dto;

import z.ivan.model.Link;

public class LinkEditDto {
    private Long id;
    private String linkValue;
    private Long literatureId;
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
    }

    public Long getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Long literatureId) {
        this.literatureId = literatureId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Link getLink() {
        Link link = new Link();
        link.setLinkId(id);
        link.setLink(linkValue);
        link.setLiteratureId(literatureId);
        return link;
    }
}

