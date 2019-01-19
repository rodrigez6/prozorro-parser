package org.rodrigez.model.domain;

import org.rodrigez.model.dto.*;

import javax.persistence.*;
import java.net.URI;
import java.util.Date;

@Entity
@Table(name = "item", schema = "prozorro")
public class Item {

    @Id
    @Column(name = "item_id")
    private String itemId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

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

    @Column(name = "related_lot")
    private String relatedLot;

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Item() {
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

        this.relatedLot = dto.getRelatedLot();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("itemId='").append(itemId).append('\'');
        sb.append(", tender=").append(tender.getTenderId());
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
        sb.append(", relatedLot='").append(relatedLot).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
