package z.ivan.model;

import java.util.Objects;

public class Link {

    private Long linkId;
    private String link;
    private Long literatureId;

    public Link() {
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Long literatureId) {
        this.literatureId = literatureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return Objects.equals(linkId, link1.linkId) &&
                Objects.equals(link, link1.link) &&
                Objects.equals(literatureId, link1.literatureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, link, literatureId);
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                ", literatureId=" + literatureId +
                '}';
    }
}
