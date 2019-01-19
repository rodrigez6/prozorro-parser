package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class AddressDTO {

    @SerializedName("streetAddress")
    private String streetAddress;

    @SerializedName("locality")
    private String locality;

    @SerializedName("region")
    private String region;

    @SerializedName("postalCode")
    private String postalCode;

    @SerializedName("countryName")
    private String countryName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressDTO{");
        sb.append("streetAddress='").append(streetAddress).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
