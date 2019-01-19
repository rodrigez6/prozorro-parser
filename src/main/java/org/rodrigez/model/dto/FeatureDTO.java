package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeatureDTO {

    @SerializedName("code")
    private String code;

    @SerializedName("featureOf")
    private String featureOf;

    @SerializedName("relatedItem")
    private String relatedItem;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("enum")
    private List<String> valuesList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeatureDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", featureOf='").append(featureOf).append('\'');
        sb.append(", relatedItem='").append(relatedItem).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", valuesList=").append(valuesList);
        sb.append('}');
        return sb.toString();
    }
}
