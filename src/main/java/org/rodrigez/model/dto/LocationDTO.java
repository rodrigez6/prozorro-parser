package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class LocationDTO {

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("elevation")
    private String elevation;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocationDTO{");
        sb.append("latitude='").append(latitude).append('\'');
        sb.append(", longitude='").append(longitude).append('\'');
        sb.append(", elevation='").append(elevation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
