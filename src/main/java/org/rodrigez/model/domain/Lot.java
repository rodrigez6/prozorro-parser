package org.rodrigez.model.domain;

import org.rodrigez.model.dto.GuaranteeDTO;
import org.rodrigez.model.dto.LotDTO;
import org.rodrigez.model.dto.PeriodDTO;
import org.rodrigez.model.dto.ValueDTO;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "lot", schema = "prozorro")
public class Lot {

    @Id
    @Column(name = "lot_id")
    private String lotId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @OneToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Feature> features = new HashSet<>();

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<LotValue> lotValues = new HashSet<>();

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Complaint> complaints = new HashSet<>();

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

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

    @Column(name = "auction_period_start_date")
    private Date auctionPeriodStartDate;

    @Column(name = "auction_period_end_date")
    private Date auctionPeriodEndDate;

    @Column(name = "auction_url")
    private String auctionUrl;

    @Column(name = "status")
    private String status;

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void addItem(Item item){
        item.setLot(this);
        items.add(item);
    }

    public void addFeature(Feature feature){
        feature.setLot(this);
        features.add(feature);
    }

    public void addLotValue(LotValue lotValue){
        lotValue.setLot(this);
        lotValues.add(lotValue);
    }

    public void addComplaint(Complaint complaint){
        complaint.setLot(this);
        complaints.add(complaint);
    }

    public void addQuestion(Question question){
        question.setLot(this);
        questions.add(question);
    }

    public Lot() {
    }

    public Lot(LotDTO dto) {
        this.lotId = dto.getId();

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

        PeriodDTO auctionPeriod = dto.getAuctionPeriodDTO();
        if(auctionPeriod!=null){
            this.auctionPeriodStartDate = auctionPeriod.getStartDate();
            this.auctionPeriodEndDate = auctionPeriod.getEndDate();
        }

        URL auctionUrl = dto.getUrl();
        if(auctionUrl!=null){
            this.auctionUrl = auctionUrl.toString();
        }

        this.status = dto.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return lotId.equals(lot.lotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lot{");
        sb.append("lotId='").append(lotId).append('\'');
        sb.append(", tender=").append(tender.getTenderId());
        sb.append(", items=").append(items);
        sb.append(", features=").append(features);
        sb.append(", documents=").append(documents);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", guaranteeAmount=").append(guaranteeAmount);
        sb.append(", guaranteeCurrency='").append(guaranteeCurrency).append('\'');
        sb.append(", date=").append(date);
        sb.append(", minimalStepAmount=").append(minimalStepAmount);
        sb.append(", minimalStepCurrency='").append(minimalStepCurrency).append('\'');
        sb.append(", minimalStepAddedTaxIncluded=").append(minimalStepAddedTaxIncluded);
        sb.append(", auctionPeriodStartDate=").append(auctionPeriodStartDate);
        sb.append(", auctionPeriodEndDate=").append(auctionPeriodEndDate);
        sb.append(", auctionUrl='").append(auctionUrl).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
