package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class ParameterDTO {

    @SerializedName("code")
    private String code;

    @SerializedName("value")
    private float value;

    public String getCode() {
        return code;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParameterDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
