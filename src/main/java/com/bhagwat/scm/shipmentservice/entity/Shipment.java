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
    private Address customerAddress;

    @Embedded
    private Address sourceAddress;

    @Embedded
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

