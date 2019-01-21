package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDTO {

    @SerializedName("name")
    private String name;

    @SerializedName("identifier")
    private IdentifierDTO identifierDTO;

    @SerializedName("additionalIdentifiers")
    private List<IdentifierDTO> identifierDTOList = new ArrayList<>();

    @SerializedName("address")
    private AddressDTO addressDTO;

    @SerializedName("contactPoint")
    private ContactPointDTO contactPointDTO;

    public String getName() {
        return name;
    }

    public IdentifierDTO getIdentifierDTO() {
        return identifierDTO;
    }

    public List<IdentifierDTO> getIdentifierDTOList() {
        return identifierDTOList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public ContactPointDTO getContactPointDTO() {
        return contactPointDTO;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrganizationDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", identifierDTO=").append(identifierDTO);
        sb.append(", identifierDTOList=").append(identifierDTOList);
        sb.append(", addressDTO=").append(addressDTO);
        sb.append(", contactPointDTO=").append(contactPointDTO);
        sb.append('}');
        return sb.toString();
    }
}
