package org.rodrigez.model.domain;

import org.rodrigez.model.dto.FeatureDTO;
import org.rodrigez.model.dto.FeatureValueDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "feature" , schema = "prozorro")
public class Feature implements Serializable {

    @Id
    @Column(name = "feature_id")
    private String featureId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
    private List<FeatureValue> featureValueList = new ArrayList<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;



    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getFeatureId() {
        return featureId;
    }

    public Feature() {
    }

    public Feature(FeatureDTO dto) {
        this.featureId = dto.getCode();
        this.title = dto.getTitle();
        this.description = dto.getDescription();

        for(FeatureValueDTO featureValueDTO:dto.getValuesList()){
            FeatureValue featureValue = new FeatureValue(featureValueDTO);
            featureValue.setFeature(this);
            featureValueList.add(featureValue);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return featureId.equals(feature.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feature{");
        sb.append("featureId='").append(featureId).append('\'');
        sb.append(", tender=").append(tender.getTenderId());
        sb.append(", lot=").append(lot.getLotId());
        sb.append(", item=").append(item.getItemId());
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", featureValueList=").append(featureValueList);
        sb.append('}');
        return sb.toString();
    }
}
