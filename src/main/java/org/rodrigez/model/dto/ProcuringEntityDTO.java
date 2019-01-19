package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/*
   OrganizationDTO conducting the tender.
*/

public class ProcuringEntityDTO {

    @SerializedName("name")
    private String name;

    @SerializedName("identifier")
    private IdentifierDTO identifierDTO;

    @SerializedName("additionalIdentifiers")
    private List<IdentifierDTO> additionalIdentifiersList = new ArrayList<>();

    @SerializedName("address")
    private AddressDTO addressDTO;

    @SerializedName("contactPoint")
    private ContactPointDTO contactPointDTO;

    @SerializedName("kind")
    private String kind;

    public String getName() {
        return name;
    }

    public IdentifierDTO getIdentifierDTO() {
        return identifierDTO;
    }

    public List<IdentifierDTO> getAdditionalIdentifiersList() {
        return additionalIdentifiersList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public ContactPointDTO getContactPointDTO() {
        return contactPointDTO;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProcuringEntityDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", identifierDTO=").append(identifierDTO);
        sb.append(", additionalIdentifiersList=").append(additionalIdentifiersList);
        sb.append(", addressDTO=").append(addressDTO);
        sb.append(", contactPointDTO=").append(contactPointDTO);
        sb.append(", kind='").append(kind).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
