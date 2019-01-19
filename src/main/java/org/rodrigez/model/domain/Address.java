package org.rodrigez.model.domain;

import org.rodrigez.model.dto.AddressDTO;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name = "address_street_address")
    private String streetAddress;

    @Column(name = "address_locality")
    private String locality;

    @Column(name = "address_region")
    private String region;

    @Column(name = "address_postal_code")
    private String postalCode;

    @Column(name = "address_country_name")
    private String countryName;

    public Address() {
    }

    public Address(AddressDTO dto) {
        this.streetAddress = dto.getStreetAddress();
        this.locality = dto.getLocality();
        this.region = dto.getRegion();
        this.postalCode = dto.getPostalCode();
        this.countryName = dto.getCountryName();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append(", streetAddress='").append(streetAddress).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}