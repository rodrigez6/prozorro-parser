package org.rodrigez.model.domain;

import org.rodrigez.model.dto.AwardDTO;
import org.rodrigez.model.dto.PeriodDTO;
import org.rodrigez.model.dto.ValueDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * All qualifications (disqualifications and awards)
 */
@Entity
@Table(name = "award", schema = "prozorro")
public class Award {

    @Id
    @Column(name = "award_id")
    private String awardId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @OneToOne(mappedBy = "award")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

    @OneToOne(mappedBy = "award", cascade = CascadeType.ALL)
    private Contract contract;

    @ManyToMany(mappedBy = "awards", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Organization> organizations = new HashSet<>();

    @OneToMany(mappedBy = "award",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "award", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "award", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Complaint> complaints = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @Column(name = "value_amount")
    private float valueAmount;

    @Column(name = "value_currency")
    private String valueCurrency;

    @Column(name = "value_added_tax_included")
    private boolean valueAddedTaxIncluded;

    @Column(name = "complaint_period_start_date")
    private Date complaintPeriodStartDate;

    @Column(name = "complaint_period_end_date")
    private Date complaintPeriodEndDate;

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Tender getTender() {
        return tender;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Lot getLot() {
        return lot;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void addOrganization(Organization organization){
        organization.addAward(this);
        organizations.add(organization);
    }

    public void addItem(Item item){
        item.setAward(this);
        items.add(item);
    }

    public void addDocument(Document document){
        document.setAward(this);
        documents.add(document);
    }

    public void addComplaint(Complaint complaint){
        complaint.setAward(this);
        complaints.add(complaint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return awardId.equals(award.awardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardId);
    }

    public Award() {
    }

    public Award(AwardDTO dto) {
        this.awardId = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.status = dto.getStatus();
        this.date = dto.getDate();

        ValueDTO value = dto.getValueDTO();
        if(value!=null){
            this.valueAmount = value.getAmount();
            this.valueCurrency = value.getCurrency();
            this.valueAddedTaxIncluded = value.isValueAddedTaxIncluded();
        }

        PeriodDTO complaintPeriod = dto.getComplaintPeriodDTO();
        if(complaintPeriod!=null){
            this.complaintPeriodStartDate = complaintPeriod.getStartDate();
            this.complaintPeriodEndDate = complaintPeriod.getEndDate();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Award{");
        sb.append("awardId='").append(awardId).append('\'');
        if(tender!=null){
            sb.append(", tender=").append(tender.getTenderId());
        }
        if(lot!=null){
            sb.append(", lot=").append(lot.getLotId());
        }
        if(bid!=null){
            sb.append(", bid=").append(bid.getBidId());
        }
        sb.append(", organizations=").append(organizations);
        sb.append(", items=").append(items);
        sb.append(", documents=").append(documents);
        sb.append(", complaints=").append(complaints);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", date=").append(date);
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", complaintPeriodStartDate=").append(complaintPeriodStartDate);
        sb.append(", complaintPeriodEndDate=").append(complaintPeriodEndDate);
        sb.append('}');
        return sb.toString();
    }
}
