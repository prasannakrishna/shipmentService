package com.bhagwat.scm.shipmentservice.dto;


import com.bhagwat.scm.shipmentservice.common.Constants;
import com.bhagwat.scm.shipmentservice.common.Constants.*;
import com.bhagwat.scm.shipmentservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateShipmentCommand {
    private String shipmentId;
    private String orderId;
    private String sellerId;
    private String customerId;
    private Address customerAddress;
    private Address sourceAddress;
    private Address targetAddress;
    private Constants.ShipmentStatus status;
    private Double price;
    private Double weight;
    private WeightUOM weightUOM;
    private DimensionUOM dimensionUOM;
    private Double volume;
    private VolumeUOM volumeUOM;
}

