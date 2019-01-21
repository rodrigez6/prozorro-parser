package org.rodrigez.model.domain;

import org.rodrigez.model.dto.*;

import javax.persistence.*;
import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "item", schema = "prozorro")
public class Item {

    @Id
    @Column(name = "item_id")
    private String itemId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tender_item",
            schema = "prozorro",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "tender_id")}
    )
    private Set<Tender> tenders = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Feature> features = new HashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet<>();

    @Column(name = "description")
    private String description;

    @Column(name = "classification_scheme")
    private String classificationScheme;

    @Column(name = "classification_id")
    private String classificationId;

    @Column(name = "classification_description")
    private String classificationDescription;

    @Column(name = "classification_uri")
    private String classificationURI;

    @Column(name = "unit_code")
    private String unitCode;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "delivery_date_start_date")
    private Date deliveryDateStartDate;

    @Column(name = "delivery_date_end_date")
    private Date deliveryDateEndDate;

    @Column(name = "delivery_address_street_address")
    private String deliveryAddressStreetAddress;

    @Column(name = "delivery_address_locality")
    private String deliveryAddressLocality;

    @Column(name = "delivery_address_region")
    private String deliveryAddressRegion;

    @Column(name = "delivery_address_postal_code")
    private String deliveryAddressPostalCode;

    @Column(name = "delivery_address_country_name")
    private String deliveryAddressCountryName;

    @Column(name = "delivery_location_latitude")
    private String deliveryLocationLatitude;

    @Column(name = "delivery_location_longitude")
    private String deliveryLocationLongitude;

    @Column(name = "delivery_location_elevation")
    private String deliveryLocationElevation;

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public String getItemId() {
        return itemId;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void addFeature(Feature feature){
        feature.setItem(this);
        features.add(feature);
    }

    public void addDocument(Document document){
        document.setItem(this);
        documents.add(document);
    }

    public void addQuestion(Question question){
        question.setItem(this);
        questions.add(question);
    }

    public void addTender(Tender tender){
        tender.addItem(this);
        tenders.add(tender);
    }

    public Item() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    public Item(ItemDTO dto) {

        this.itemId = dto.getId();
        this.description = dto.getDescription();

        ClassificationDTO classificationDTO = dto.getClassificationDTO();
        if(classificationDTO!=null){
            this.classificationScheme = classificationDTO.getScheme();
            this.classificationId = classificationDTO.getId();
            this.classificationDescription = classificationDTO.getDescription();

            URI classificationUri = classificationDTO.getUri();
            if(classificationUri!=null){
                this.classificationURI = classificationUri.toString();
            }
        }

        UnitDTO unitDTO = dto.getUnitDTO();
        if(unitDTO!=null){
            this.unitCode = unitDTO.getCode();
            this.unitName = unitDTO.getName();
        }

        this.quantity = dto.getQuantity();

        PeriodDTO deliveryDate = dto.getDeliveryDate();
        if(deliveryDate!=null){
            this.deliveryDateStartDate = deliveryDate.getStartDate();
            this.deliveryDateEndDate = deliveryDate.getEndDate();
        }

        AddressDTO deliveryAddress = dto.getDeliveryAddressDTO();
        if(deliveryAddress!=null){
            this.deliveryAddressStreetAddress = deliveryAddress.getStreetAddress();
            this.deliveryAddressLocality = deliveryAddress.getLocality();
            this.deliveryAddressRegion = deliveryAddress.getRegion();
            this.deliveryAddressPostalCode = deliveryAddress.getPostalCode();
            this.deliveryAddressCountryName = deliveryAddress.getCountryName();
        }

        LocationDTO deliveryLocation = dto.getDeliveryLocationDTO();
        if(deliveryLocation!=null){
            this.deliveryLocationLatitude = deliveryLocation.getLatitude();
            this.deliveryLocationLongitude = deliveryLocation.getLongitude();
            this.deliveryLocationElevation = deliveryLocation.getElevation();
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("itemId='").append(itemId).append('\'');
        if (lot!=null){
            sb.append(", lot=").append(lot.getLotId());
        }
        sb.append(", documents=").append(documents);
        sb.append(", features=").append(features);
        sb.append(", description='").append(description).append('\'');
        sb.append(", classificationScheme='").append(classificationScheme).append('\'');
        sb.append(", classificationId='").append(classificationId).append('\'');
        sb.append(", classificationDescription='").append(classificationDescription).append('\'');
        sb.append(", classificationURI='").append(classificationURI).append('\'');
        sb.append(", unitCode='").append(unitCode).append('\'');
        sb.append(", unitName='").append(unitName).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", deliveryDateStartDate=").append(deliveryDateStartDate);
        sb.append(", deliveryDateEndDate=").append(deliveryDateEndDate);
        sb.append(", deliveryAddressStreetAddress='").append(deliveryAddressStreetAddress).append('\'');
        sb.append(", deliveryAddressLocality='").append(deliveryAddressLocality).append('\'');
        sb.append(", deliveryAddressRegion='").append(deliveryAddressRegion).append('\'');
        sb.append(", deliveryAddressPostalCode='").append(deliveryAddressPostalCode).append('\'');
        sb.append(", deliveryAddressCountryName='").append(deliveryAddressCountryName).append('\'');
        sb.append(", deliveryLocationLatitude='").append(deliveryLocationLatitude).append('\'');
        sb.append(", deliveryLocationLongitude='").append(deliveryLocationLongitude).append('\'');
        sb.append(", deliveryLocationElevation='").append(deliveryLocationElevation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
