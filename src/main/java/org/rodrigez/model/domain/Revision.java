package org.rodrigez.model.domain;

import org.rodrigez.model.dto.RevisionDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "revision", schema = "prozorro")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revision_id")
    private int revisionId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "revision" ,cascade = CascadeType.ALL)
    private Set<RevisionChange> revisionChanges = new HashSet<>();

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Revision(){
    }

    public Revision(RevisionDTO dto){
        this.date = dto.getDate();

        for(String description: dto.getChangeList()){
            RevisionChange revisionChange = new RevisionChange(description);
            revisionChanges.add(revisionChange);
        }
    }
}
