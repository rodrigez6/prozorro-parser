package org.rodrigez.model.domain;

import org.rodrigez.model.dto.AddressDTO;
import org.rodrigez.model.dto.ContactPointDTO;
import org.rodrigez.model.dto.OrganizationDTO;

import javax.persistence.*;
import javax.smartcardio.CommandAPDU;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "organization", schema = "prozorro")
public class Organization {

    @Id
    @Column(name = "organization_id")
    private String organizationId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bid_organization",
            schema = "prozorro",
            joinColumns = {@JoinColumn(name = "organization_id")},
            inverseJoinColumns = {@JoinColumn(name = "bid_id")}
    )
    private Set<Bid> bids = new HashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<Complaint> complaints = new HashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<Question> questions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "tender_organization_funders",
            schema = "prozorro",
            joinColumns = {@JoinColumn(name = "organization_id")},
            inverseJoinColumns = {@JoinColumn(name = "tender_id")}
    )
    private Set<Tender> fundersTenders = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "contract_organization_suppliers",
            schema = "prozorro",
            joinColumns = {@JoinColumn(name = "organization_id")},
            inverseJoinColumns = {@JoinColumn(name = "contract_id")}
    )
    private Set<Contract> contracts = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "award_organization",
            schema = "prozorro",
            joinColumns =  {@JoinColumn(name = "organization_id")},
            inverseJoinColumns = {@JoinColumn(name = "award_id")}
    )
    private Set<Award> awards = new HashSet<>();

    @Column(name = "identifier_scheme")
    private String identifierScheme;

    @Column(name = "identifier_legal_name")
    private String identifierLegalName;

    @Column(name = "identifier_uri")
    private String identifierUri;

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

    public void addBid(Bid bid){
        bids.add(bid);
    }

    public void addComplaint(Complaint complaint){
        complaint.setOrganization(this);
        complaints.add(complaint);
    }

    public void addFundersTender(Tender tender){
        fundersTenders.add(tender);
    }

    public void addQuestion(Question question){
        question.setOrganization(this);
        questions.add(question);
    }

    public void addContract(Contract contract){
        contract.addSupplier(this);
        contracts.add(contract);
    }

    public void addAward(Award award){
        award.addOrganization(this);
        awards.add(award);
    }

    public Organization() {
    }

    public Organization(OrganizationDTO dto){

        this.organizationId = dto.getIdentifierDTO().getId();
        this.identifierLegalName = dto.getIdentifierDTO().getLegalName();
        this.identifierScheme = dto.getIdentifierDTO().getScheme();

        URI identifierUri = dto.getIdentifierDTO().getUri();
        if(identifierUri!=null){
            this.identifierUri = identifierUri.toString();
        }

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
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organization{");
        sb.append("organizationId='").append(organizationId).append('\'');
        sb.append(", bids=").append(bids);
        sb.append(", identifierScheme='").append(identifierScheme).append('\'');
        sb.append(", identifierLegalName='").append(identifierLegalName).append('\'');
        sb.append(", identifierUri='").append(identifierUri).append('\'');
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
        sb.append('}');
        return sb.toString();
    }
}
