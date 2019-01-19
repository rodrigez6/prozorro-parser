package org.rodrigez.model.domain;

import org.rodrigez.model.dto.*;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "procuring_entity_id", referencedColumnName = "procuring_entity_id")
    private ProcuringEntity procuringEntity;

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

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

    public List<Item> getItemList() {
        return itemList;
    }

    public String getTenderId() {
        return tenderId;
    }

    public Tender() {
    }

    public Tender(TenderDTO dto) {

        this.tenderId = dto.getTenderId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();

        this.procuringEntity = new ProcuringEntity(dto.getProcuringEntityDTO());

        for(ItemDTO itemDTO:dto.getItemDTOList()){
            Item item = new Item(itemDTO);
            item.setTender(this);
            itemList.add(item);
        }

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
        sb.append(", itemList=").append(itemList);
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
