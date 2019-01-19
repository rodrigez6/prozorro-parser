package org.rodrigez.model.domain;

import org.rodrigez.model.dto.ContactPointDTO;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "contact_point", schema = "prozorro")
public class ContactPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_point_id")
    private int contactPointId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "url")
    private String url;

    public ContactPoint() {
    }

    public ContactPoint(ContactPointDTO dto) {

        this.name = dto.getName();
        this.email = dto.getEmail();
        this.telephone = dto.getTelephone();
        this.faxNumber = dto.getFaxNumber();

        URL url = dto.getUrl();
        if(url!=null){
            this.url = url.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactPoint{");
        sb.append("contactPointId=").append(contactPointId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", faxNumber='").append(faxNumber).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
