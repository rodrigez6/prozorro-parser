package org.rodrigez.model.domain;

import org.rodrigez.model.dto.*;

import javax.persistence.*;
import java.net.URL;
import java.util.*;

@Entity
@Table(name = "tender", schema = "prozorro")
public class Tender {

    @Id
    @Column(name = "tender_id")
    private String tenderId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuring_entity_id", referencedColumnName = "procuring_entity_id")
    private ProcuringEntity procuringEntity;

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Feature> features = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Lot> lots = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Award> awards = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Contract> contracts = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new HashSet<>();

    @ManyToMany(mappedBy = "fundersTenders", cascade = CascadeType.ALL)
    private Set<Organization> funders = new HashSet<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private Set<Revision> revisions = new HashSet<>();

    @Column(name = "value_amount")
    private float valueAmount;

    @Column(name = "value_currency")
    private String valueCurrency;

    @Column(name = "value_added_tax_included")
    private boolean valueAddedTaxIncluded;

    @Column(name = "guarantee_amount")
    private float guaranteeAmount;

    @Column(name = "guarantee_currency")
    private String guaranteeCurrency;

    @Column(name = "date")
    private Date date;

    @Column(name = "minimal_step_amount")
    private float minimalStepAmount;

    @Column(name = "minimal_step_currency")
    private String minimalStepCurrency;

    @Column(name = "minimal_step_added_tax_included")
    private boolean minimalStepAddedTaxIncluded;

    @Column(name = "enquiry_period_start_date")
    private Date enquiryPeriodStartDate;

    @Column(name = "enquiry_period_end_date")
    private Date enquiryPeriodEndDate;

    @Column(name = "tender_period_start_date")
    private Date tenderPeriodStartDate;

    @Column(name = "tender_period_end_date")
    private Date tenderPeriodEndDate;

    @Column(name = "auction_period_start_date")
    private Date auctionPeriodStartDate;

    @Column(name = "auction_period_end_date")
    private Date auctionPeriodEndDate;

    @Column(name = "auction_url")
    private String auctionUrl;

    @Column(name = "award_period_start_date")
    private Date awardPeriodStartDate;

    @Column(name = "award_period_end_date")
    private Date awardPeriodEndDate;

    @Column(name = "status")
    private String status;

    public ProcuringEntity getProcuringEntity() {
        return procuringEntity;
    }

    public void setProcuringEntity(ProcuringEntity procuringEntity) {
        this.procuringEntity = procuringEntity;
    }

    public Set<Item> getItems() {
        return items;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public Set<Lot> getLots() {
        return lots;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public float getValueAmount() {
        return valueAmount;
    }

    public String getValueCurrency() {
        return valueCurrency;
    }

    public boolean isValueAddedTaxIncluded() {
        return valueAddedTaxIncluded;
    }

    public float getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public String getGuaranteeCurrency() {
        return guaranteeCurrency;
    }

    public Date getDate() {
        return date;
    }

    public float getMinimalStepAmount() {
        return minimalStepAmount;
    }

    public String getMinimalStepCurrency() {
        return minimalStepCurrency;
    }

    public boolean isMinimalStepAddedTaxIncluded() {
        return minimalStepAddedTaxIncluded;
    }

    public Date getEnquiryPeriodStartDate() {
        return enquiryPeriodStartDate;
    }

    public Date getEnquiryPeriodEndDate() {
        return enquiryPeriodEndDate;
    }

    public Date getTenderPeriodStartDate() {
        return tenderPeriodStartDate;
    }

    public Date getTenderPeriodEndDate() {
        return tenderPeriodEndDate;
    }

    public Date getAuctionPeriodStartDate() {
        return auctionPeriodStartDate;
    }

    public String getAuctionUrl() {
        return auctionUrl;
    }

    public Date getAwardPeriodStartDate() {
        return awardPeriodStartDate;
    }

    public Date getAwardPeriodEndDate() {
        return awardPeriodEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void addDocument(Document document){
        document.setTender(this);
        documents.add(document);
    }

    public void addLot(Lot lot) {
        lot.setTender(this);
        lots.add(lot);
    }

    public void addItem(Item item){
        item.setTender(this);
        items.add(item);
    }

    public void addFeature(Feature feature){
        feature.setTender(this);
        features.add(feature);
    }

    public void addBid(Bid bid){
        bid.setTender(this);
        bids.add(bid);
    }

    public void addContract(Contract contract){
        contract.setTender(this);
        contracts.add(contract);
    }

    public void addFunder(Organization funder){
        funder.addFundersTender(this);
        funders.add(funder);
    }

    public void addRevision(Revision revision){
        revision.setTender(this);
        revisions.add(revision);
    }

    public Tender() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tender tender = (Tender) o;
        return tenderId.equals(tender.tenderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenderId);
    }

    public Tender(TenderDTO dto) {

        this.tenderId = dto.getTenderId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();

        ValueDTO value = dto.getValueDTO();
        if(value!=null){
            this.valueAmount = value.getAmount();
            this.valueCurrency = value.getCurrency();
            this.valueAddedTaxIncluded = value.isValueAddedTaxIncluded();
        }

        GuaranteeDTO guarantee = dto.getGuaranteeDTO();
        if(guarantee!=null){
            this.guaranteeAmount = guarantee.getAmount();
            this.guaranteeCurrency = guarantee.getCurrency();
        }

        this.date = dto.getDate();

        ValueDTO minimalStep = dto.getMinimalStep();
        if(minimalStep!=null){
            this.minimalStepAmount = minimalStep.getAmount();
            this.minimalStepCurrency = minimalStep.getCurrency();
            this.minimalStepAddedTaxIncluded = minimalStep.isValueAddedTaxIncluded();
        }

        PeriodDTO enquiryPeriod = dto.getEnquiryPeriodDTO();
        if(enquiryPeriod!=null){
            this.enquiryPeriodStartDate = enquiryPeriod.getStartDate();
            this.enquiryPeriodEndDate = enquiryPeriod.getEndDate();
        }

        PeriodDTO tenderPeriod = dto.getTenderPeriodDTO();
        if(tenderPeriod!=null){
            this.tenderPeriodStartDate = tenderPeriod.getStartDate();
            this.tenderPeriodEndDate = tenderPeriod.getEndDate();
        }

        PeriodDTO auctionPeriod = dto.getAuctionPeriodDTO();
        if(auctionPeriod!=null){
            this.auctionPeriodStartDate = auctionPeriod.getStartDate();
            this.auctionPeriodEndDate = auctionPeriod.getEndDate();
        }

        URL auctionUrl = dto.getAuctionUrl();
        if(auctionUrl!=null){
            this.auctionUrl = auctionUrl.toString();
        }

        PeriodDTO awardPeriod = dto.getAwardPeriodDTO();
        if(awardPeriod!=null){
            this.awardPeriodStartDate = awardPeriod.getStartDate();
            this.awardPeriodEndDate = awardPeriod.getEndDate();
        }

        this.status = dto.getStatus();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tender{");
        sb.append("tenderId='").append(tenderId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", procuringEntity=").append(procuringEntity);
        sb.append(", items=").append(items);
        sb.append(", features=").append(features);
        sb.append(", documents=").append(documents);
        sb.append(", lots=").append(lots);
        sb.append(", questions=").append(questions);
        sb.append(", bids=").append(bids);
        sb.append(", awards=").append(awards);
        sb.append(", contracts=").append(contracts);
        sb.append(", complaints=").append(complaints);
        sb.append(", funders=").append(funders);
        sb.append(", revisions=").append(revisions);
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", guaranteeAmount=").append(guaranteeAmount);
        sb.append(", guaranteeCurrency='").append(guaranteeCurrency).append('\'');
        sb.append(", date=").append(date);
        sb.append(", minimalStepAmount=").append(minimalStepAmount);
        sb.append(", minimalStepCurrency='").append(minimalStepCurrency).append('\'');
        sb.append(", minimalStepAddedTaxIncluded=").append(minimalStepAddedTaxIncluded);
        sb.append(", enquiryPeriodStartDate=").append(enquiryPeriodStartDate);
        sb.append(", enquiryPeriodEndDate=").append(enquiryPeriodEndDate);
        sb.append(", tenderPeriodStartDate=").append(tenderPeriodStartDate);
        sb.append(", tenderPeriodEndDate=").append(tenderPeriodEndDate);
        sb.append(", auctionPeriodStartDate=").append(auctionPeriodStartDate);
        sb.append(", auctionPeriodEndDate=").append(auctionPeriodEndDate);
        sb.append(", auctionUrl='").append(auctionUrl).append('\'');
        sb.append(", awardPeriodStartDate=").append(awardPeriodStartDate);
        sb.append(", awardPeriodEndDate=").append(awardPeriodEndDate);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
