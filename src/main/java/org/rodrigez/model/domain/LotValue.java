package org.rodrigez.model.domain;

import org.rodrigez.model.dto.LotValueDTO;
import org.rodrigez.model.dto.ValueDTO;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
@Table(name = "lot_value", schema = "prozorro")
public class LotValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_value_id")
    private int lotValueId;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

    @Column(name = "value_amount")
    private float valueAmount;

    @Column(name = "value_currency")
    private String valueCurrency;

    @Column(name = "value_added_tax_included")
    private boolean valueAddedTaxIncluded;

    @Column(name = "date")
    private Date date;

    @Column(name = "participation_url")
    private String participationUrl;

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public LotValue() {
    }

    public LotValue(LotValueDTO dto) {
        ValueDTO value = dto.getValueDTO();
        if(value!=null){
            this.valueAmount = value.getAmount();
            this.valueCurrency = value.getCurrency();
            this.valueAddedTaxIncluded = value.isValueAddedTaxIncluded();
        }

        this.date = dto.getDate();

        URL participationUrl = dto.getParticipationUrl();
        if(participationUrl!=null){
            this.participationUrl = participationUrl.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LotValue{");
        sb.append("lotValueId=").append(lotValueId);
        sb.append(", lot=").append(lot.getLotId());
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", date=").append(date);
        sb.append(", participationUrl='").append(participationUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
