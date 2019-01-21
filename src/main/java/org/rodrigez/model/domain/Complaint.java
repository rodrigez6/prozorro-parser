package org.rodrigez.model.domain;

import org.rodrigez.model.dto.ComplaintDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @Column(name = "complaint_id")
    private String complaintId;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @OneToMany(mappedBy = "complaint")
    private Set<Document> documents = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name= "date_submitted")
    private Date dateSubmitted;

    @Column(name = "date_answered")
    private Date dateAnswered;

    @Column(name = "date_escalated")
    private Date dateEscalated;

    @Column(name = "date_cancelled")
    private Date dateCancelled;

    @Column(name = "date_decision")
    private Date dateDecision;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "resolution_type")
    private String resolutionType;

    @Column(name = "satisfied")
    private String satisfied;

    @Column(name = "decision")
    private String decision;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(name = "tenderer_action")
    private String tendererAction;

    @Column(name = "tenderer_action_date")
    private Date tendererActionDate;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void addDocument(Document document){
        document.setComplaint(this);
        documents.add(document);
    }

    public Complaint() {
    }

    public Complaint(ComplaintDTO dto) {
        this.complaintId = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.date = dto.getDate();
        this.dateSubmitted = dto.getDateSubmitted();
        this.dateAnswered = dto.getDateAnswered();
        this.dateEscalated = dto.getDateEscalated();
        this.dateCancelled = dto.getDateCancelled();
        this.dateDecision = dto.getDateDecision();
        this.status = dto.getStatus();
        this.type = dto.getType();
        this.resolution = dto.getResolution();
        this.resolutionType = dto.getResolutionType();
        this.satisfied = dto.getSatisfied();
        this.decision = dto.getDecision();
        this.cancellationReason = dto.getCancellationReason();
        this.tendererAction = dto.getTendererAction();
        this.tendererActionDate = dto.getTendererActionDate();
    }

}
