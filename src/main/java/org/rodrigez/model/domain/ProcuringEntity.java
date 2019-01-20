package org.rodrigez.model.domain;

import org.rodrigez.model.dto.AddressDTO;
import org.rodrigez.model.dto.ContactPointDTO;
import org.rodrigez.model.dto.ProcuringEntityDTO;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "procuring_entity", schema = "prozorro")
public class ProcuringEntity {

    @Id
    @Column(name = "procuring_entity_id")
    private String procuringEntityId;

    @OneToMany(mappedBy = "procuringEntity")
    private List<Tender> tenderList = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @Column(name = "address_street_address")
    private String addressStreetAddress;

    @Column(name = "address_locality")
    private String addressLocality;

    @Column(name = "address_region")
    private String addressRegion;

    @Column(name = "address_postal_code")
    private String addressPostalCode;

    @Column(name = "address_country_name")
    private String addressCountryName;

    @Column(name = "contact_point_name")
    private String contactPointName;

    @Column(name = "contact_point_email")
    private String contactPointEmail;

    @Column(name = "contact_point_telephone")
    private String contactPointTelephone;

    @Column(name = "contact_point_fax_number")
    private String contactPointFaxNumber;

    @Column(name = "contact_point_url")
    private String contactPointUrl;

    @Column(name = "kind")
    private String kind;

    public String getProcuringEntityId() {
        return procuringEntityId;
    }

    public List<Tender> getTenderList() {
        return tenderList;
    }

    public String getName() {
        return name;
    }

    public String getAddressStreetAddress() {
        return addressStreetAddress;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public String getAddressCountryName() {
        return addressCountryName;
    }

    public String getContactPointName() {
        return contactPointName;
    }

    public String getContactPointEmail() {
        return contactPointEmail;
    }

    public String getContactPointTelephone() {
        return contactPointTelephone;
    }

    public String getContactPointFaxNumber() {
        return contactPointFaxNumber;
    }

    public String getContactPointUrl() {
        return contactPointUrl;
    }

    public String getKind() {
        return kind;
    }

    public ProcuringEntity() {
    }

    public ProcuringEntity(ProcuringEntityDTO dto) {

        this.procuringEntityId = dto.getIdentifierDTO().getId();
        this.name = dto.getName();

        AddressDTO addressDTO = dto.getAddressDTO();
        if(addressDTO!=null){
            this.addressStreetAddress = addressDTO.getStreetAddress();
            this.addressLocality = addressDTO.getLocality();
            this.addressRegion = addressDTO.getRegion();
            this.addressPostalCode = addressDTO.getPostalCode();
            this.addressCountryName = addressDTO.getCountryName();
        }

        ContactPointDTO contactPointDTO = dto.getContactPointDTO();
        if(contactPointDTO!=null){
            this.contactPointName = contactPointDTO.getName();
            this.contactPointEmail = contactPointDTO.getEmail();
            this.contactPointTelephone = contactPointDTO.getTelephone();
            this.contactPointFaxNumber = contactPointDTO.getFaxNumber();

            URL contactPointUrl = contactPointDTO.getUrl();
            if(contactPointUrl!=null){
                this.contactPointUrl = contactPointUrl.toString();
            }
        }

        this.kind = dto.getKind();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProcuringEntity{");
        sb.append("procuringEntityId='").append(procuringEntityId).append('\'');
        sb.append(", tenderList=").append(tenderList);
        sb.append(", name='").append(name).append('\'');
        sb.append(", addressStreetAddress='").append(addressStreetAddress).append('\'');
        sb.append(", addressLocality='").append(addressLocality).append('\'');
        sb.append(", addressRegion='").append(addressRegion).append('\'');
        sb.append(", addressPostalCode='").append(addressPostalCode).append('\'');
        sb.append(", addressCountryName='").append(addressCountryName).append('\'');
        sb.append(", contactPointName='").append(contactPointName).append('\'');
        sb.append(", contactPointEmail='").append(contactPointEmail).append('\'');
        sb.append(", contactPointTelephone='").append(contactPointTelephone).append('\'');
        sb.append(", contactPointFaxNumber='").append(contactPointFaxNumber).append('\'');
        sb.append(", contactPointUrl='").append(contactPointUrl).append('\'');
        sb.append(", kind='").append(kind).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
