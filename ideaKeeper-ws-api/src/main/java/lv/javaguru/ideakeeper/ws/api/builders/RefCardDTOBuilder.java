package lv.javaguru.ideakeeper.ws.api.builders;

import java.util.Date;

import lv.javaguru.ideakeeper.ws.api.domain.RefCardDTO;

public class RefCardDTOBuilder {

    private Long id;
    private Date creationDate;
    private String title;
    private String description;
    private String link;

    private RefCardDTOBuilder() { }
    
    public static RefCardDTOBuilder createReferenceCardDTO() {
        return new RefCardDTOBuilder();
    }
    
    public RefCardDTO build() {
        RefCardDTO refCard = new RefCardDTO();
        refCard.setId(id);
        refCard.setCreationDate(creationDate);
        refCard.setTitle(title);
        refCard.setDescription(description);
        refCard.setLink(link);
        return refCard;
    }

    public RefCardDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RefCardDTOBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public RefCardDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public RefCardDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public RefCardDTOBuilder withLink(String link) {
        this.link = link;
        return this;
    }
    
}
