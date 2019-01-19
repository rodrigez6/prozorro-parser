package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class FeatureValueDTO {

    @SerializedName("value")
    private float value;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public float getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeatureValueDTO{");
        sb.append("value=").append(value);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
