package org.rodrigez.model.domain;

import com.google.gson.annotations.SerializedName;
import org.rodrigez.model.dto.FeatureDTO;
import org.rodrigez.model.dto.FeatureValueDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "feature" , schema = "prozorro")
public class Feature implements Serializable {

    @Id
    @Column(name = "feature_id")
    private String featureId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @Column(name = "feature_of")
    private String featureOf;

    @Column(name = "related_item")
    private String relatedItem;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
    private List<FeatureValue> featureValueList = new ArrayList<>();

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public String getFeatureId() {
        return featureId;
    }

    public Feature() {
    }

    public Feature(FeatureDTO dto) {
        this.featureId = dto.getCode();
        this.featureOf = dto.getFeatureOf();
        this.relatedItem = dto.getRelatedItem();
        this.title = dto.getTitle();
        this.description = dto.getDescription();

        for(FeatureValueDTO featureValueDTO:dto.getValuesList()){
            FeatureValue featureValue = new FeatureValue(featureValueDTO);
            featureValue.setFeature(this);
            featureValueList.add(featureValue);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feature{");
        sb.append("featureId='").append(featureId).append('\'');
        sb.append(", tender=").append(tender);
        sb.append(", featureOf='").append(featureOf).append('\'');
        sb.append(", relatedItem='").append(relatedItem).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", featureValueList=").append(featureValueList);
        sb.append('}');
        return sb.toString();
    }
}
