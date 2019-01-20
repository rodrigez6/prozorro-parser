package org.rodrigez.model.domain;

import org.rodrigez.model.dto.ParameterDTO;

import javax.persistence.*;

@Entity
@Table(name = "bid_parameter", schema = "prozorro")
public class BidParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_parameter_id")
    private int bidParameterId;

    @ManyToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private float value;

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public BidParameter() {
    }

    public BidParameter(ParameterDTO dto){
        this.code = dto.getCode();
        this.value = dto.getValue();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BidParameter{");
        sb.append("bid=").append(bid.getBidId());
        sb.append(", code='").append(code).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
