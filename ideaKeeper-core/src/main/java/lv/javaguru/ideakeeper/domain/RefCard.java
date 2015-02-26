package lv.javaguru.ideakeeper.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by Viktor on 25/02/2015.
 */
@Entity
@Table(name="REFERENCE_CARDS")
public class RefCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate = new Date();

    @Column(name="TITLE", nullable = true)
    private String title;

    @Column(name="DESCRIPTION", nullable = true)
    private String description;

    @Column(name="LINK", nullable = true)
    private String link;


    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
