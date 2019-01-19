package org.rodrigez.model.domain;

import org.rodrigez.model.dto.AddressDTO;
import org.rodrigez.model.dto.ContactPointDTO;
import org.rodrigez.model.dto.ProcuringEntityDTO;

import javax.persistence.*;

@Entity
@Table(name = "procuring_entity", schema = "prozorro")
public class ProcuringEntity {

    @Id
    @Column(name = "procuring_entity_id")
    private String procuringEntityId;

    @Column(name = "name")
    private String name;

    private Address address;

    private ContactPoint contactPoint;

    @Column(name = "kind")
    private String kind;

    public ProcuringEntity() {
    }

    public ProcuringEntity(ProcuringEntityDTO dto) {

        this.procuringEntityId = dto.getIdentifierDTO().getId();
        this.name = dto.getName();

        AddressDTO addressDTO = dto.getAddressDTO();
        if(addressDTO!=null){
            this.address = new Address(addressDTO);
        }
        ContactPointDTO contactPointDTO = dto.getContactPointDTO();
        if(contactPointDTO!=null){
            this.contactPoint = new ContactPoint(contactPointDTO);
        }

        this.kind = dto.getKind();
    }

    public ContactPoint getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(ContactPoint contactPoint) {
        this.contactPoint = contactPoint;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProcuringEntity{");
        sb.append("procuringEntityId='").append(procuringEntityId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", address=").append(address);
        sb.append(", contactPoint=").append(contactPoint);
        sb.append(", kind='").append(kind).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
