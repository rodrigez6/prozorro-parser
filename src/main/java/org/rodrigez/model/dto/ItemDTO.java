package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("description")
    private String description;

    @SerializedName("classification")
    private ClassificationDTO classificationDTO;

    @SerializedName("additionalClassifications")
    private List<ClassificationDTO> additionalClassificationDTOList;

    @SerializedName("unitDTO")
    private UnitDTO unitDTO;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("deliveryDate")
    private PeriodDTO deliveryDate;

    @SerializedName("deliveryAddress")
    private AddressDTO deliveryAddressDTO;

    @SerializedName("deliveryLocation")
    private LocationDTO deliveryLocationDTO;

    @SerializedName("relatedLot")
    private String relatedLot;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", classificationDTO=").append(classificationDTO);
        sb.append(", additionalClassificationDTOList=").append(additionalClassificationDTOList);
        sb.append(", unitDTO=").append(unitDTO);
        sb.append(", quantity=").append(quantity);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", deliveryAddressDTO=").append(deliveryAddressDTO);
        sb.append(", deliveryLocationDTO=").append(deliveryLocationDTO);
        sb.append(", relatedLot='").append(relatedLot).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
