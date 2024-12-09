package com.bhagwat.scm.shipmentservice.entity;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String state;
    private String country;
}

