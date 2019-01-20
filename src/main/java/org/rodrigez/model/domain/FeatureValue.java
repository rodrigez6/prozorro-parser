package org.rodrigez.model.domain;

import org.rodrigez.model.dto.FeatureValueDTO;

import javax.persistence.*;

@Entity
@Table(name = "feature_value", schema = "prozorro")
public class FeatureValue {

    @Id
    @Column(name = "feature_value_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureValueId;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @Column(name = "value")
    private float value;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public FeatureValue() {
    }

    public FeatureValue(FeatureValueDTO dto) {
        this.value = dto.getValue();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeatureValue{");
        sb.append("feature=").append(feature.getFeatureId());
        sb.append(", value=").append(value);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
