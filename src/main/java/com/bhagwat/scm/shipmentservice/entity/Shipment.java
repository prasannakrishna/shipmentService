package com.bhagwat.scm.shipmentservice.entity;

import com.bhagwat.scm.shipmentservice.common.Constants;
import jakarta.persistence.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.apache.tomcat.util.bcel.Const;

import java.util.Date;

@Entity
@Data
public class Shipment {

    @Id
    private String shipmentId;

    private String orderId;
    private String sellerId;
    private String customerId;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1", column = @Column(name = "customer_address_line1")),
        @AttributeOverride(name = "addressLine2", column = @Column(name = "customer_address_line2")),
        @AttributeOverride(name = "city",         column = @Column(name = "customer_city")),
        @AttributeOverride(name = "postCode",     column = @Column(name = "customer_post_code")),
        @AttributeOverride(name = "state",        column = @Column(name = "customer_state")),
        @AttributeOverride(name = "country",      column = @Column(name = "customer_country"))
    })
    private Address customerAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1", column = @Column(name = "source_address_line1")),
        @AttributeOverride(name = "addressLine2", column = @Column(name = "source_address_line2")),
        @AttributeOverride(name = "city",         column = @Column(name = "source_city")),
        @AttributeOverride(name = "postCode",     column = @Column(name = "source_post_code")),
        @AttributeOverride(name = "state",        column = @Column(name = "source_state")),
        @AttributeOverride(name = "country",      column = @Column(name = "source_country"))
    })
    private Address sourceAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1", column = @Column(name = "target_address_line1")),
        @AttributeOverride(name = "addressLine2", column = @Column(name = "target_address_line2")),
        @AttributeOverride(name = "city",         column = @Column(name = "target_city")),
        @AttributeOverride(name = "postCode",     column = @Column(name = "target_post_code")),
        @AttributeOverride(name = "state",        column = @Column(name = "target_state")),
        @AttributeOverride(name = "country",      column = @Column(name = "target_country"))
    })
    private Address targetAddress;

    private Date deliveryByDate;
    private Date shipByDate;
    private Date orderedByDate;
    private Date shipmentCreatedDate;

    private String consignmentId;
    private String carrierId;
    private String carrierName;

    @Enumerated(EnumType.STRING)
    private Constants.ShipmentStatus status;

    private Double price;
    private Double dimensionWidth;
    private Double dimensionHeight;
    private Double dimensionLength;

    private Double weight;

    @Enumerated(EnumType.STRING)
    private Constants.WeightUOM weightUOM;

    @Enumerated(EnumType.STRING)
    private Constants.DimensionUOM dimensionUOM;

    private Double volume;

    @Enumerated(EnumType.STRING)
    private Constants.VolumeUOM volumeUOM;
}

