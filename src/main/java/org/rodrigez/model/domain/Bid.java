package org.rodrigez.model.domain;

import org.rodrigez.model.dto.BidDTO;
import org.rodrigez.model.dto.ParameterDTO;
import org.rodrigez.model.dto.ValueDTO;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bid", schema = "prozorro")
public class Bid {

    @Id
    @Column(name = "bid_id")
    private String bidId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToMany(mappedBy = "bids")
    private Set<Organization> organizations = new HashSet<>();

    @OneToMany(mappedBy = "bid", cascade = CascadeType.ALL)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "bid", cascade = CascadeType.ALL)
    private Set<BidParameter> bidParameters = new HashSet<>();

    @OneToMany(mappedBy = "bid", cascade = CascadeType.ALL)
    private Set<LotValue> lotValues = new HashSet<>();

    @OneToMany(mappedBy = "bid", cascade = CascadeType.ALL)
    private Set<Award> awards = new HashSet<>();

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "value_amount")
    private float valueAmount;

    @Column(name = "value_currency")
    private String valueCurrency;

    @Column(name = "value_added_tax_included")
    private boolean valueAddedTaxIncluded;

    @Column(name = "participation_url")
    private String participationUrl;

    public String getBidId() {
        return bidId;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Tender getTender() {
        return tender;
    }

    public void addDocument(Document document){
        document.setBid(this);
        documents.add(document);
    }

    public void addLotValue(LotValue lotValue){
        lotValue.setBid(this);
        lotValues.add(lotValue);
    }

    public void addOrganization(Organization organization){
        organization.addBid(this);
        organizations.add(organization);
    }

    public void addParameter(BidParameter bidParameter){
        bidParameter.setBid(this);
        bidParameters.add(bidParameter);
    }

    public void addAward(Award award){
        award.setBid(this);
        awards.add(award);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return bidId.equals(bid.bidId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidId);
    }

    public Bid() {
    }

    public Bid(BidDTO dto){
        this.bidId = dto.getId();
        this.date = dto.getDate();
        this.status = dto.getStatus();

        for(ParameterDTO parameterDTO:dto.getParameterDTOList()){
            addParameter(new BidParameter(parameterDTO));
        }

        ValueDTO value = dto.getValueDTO();
        if(value!=null){
            this.valueAmount = value.getAmount();
            this.valueCurrency = value.getCurrency();
            this.valueAddedTaxIncluded = value.isValueAddedTaxIncluded();
        }

        URL participantUrl = dto.getParticipationUrl();
        if(participantUrl!=null){
            this.participationUrl = participantUrl.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bid{");
        sb.append("bidId='").append(bidId).append('\'');
        sb.append(", tender=").append(tender);
        sb.append(", organizations=").append(organizations);
        sb.append(", documents=").append(documents);
        sb.append(", bidParameters=").append(bidParameters);
        sb.append(", lotValues=").append(lotValues);
        sb.append(", awards=").append(awards);
        sb.append(", date=").append(date);
        sb.append(", status='").append(status).append('\'');
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", participationUrl='").append(participationUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
