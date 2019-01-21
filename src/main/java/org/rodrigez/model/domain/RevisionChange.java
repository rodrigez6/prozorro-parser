package org.rodrigez.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "revision_change" , schema = "prozorro")
public class RevisionChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revision_change_id")
    private int revisionChangeId;

    @ManyToOne
    @JoinColumn(name = "revision_id")
    private Revision revision;

    @Column(name = "description")
    private String description;

    public RevisionChange(String description) {
        this.description = description;
    }
}
