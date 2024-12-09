package com.bhagwat.scm.shipmentservice.dto;

import com.bhagwat.scm.shipmentservice.common.Constants;
import com.bhagwat.scm.shipmentservice.common.Constants.*;
import com.bhagwat.scm.shipmentservice.entity.Address;
import lombok.Data;

@Data
public class ShipmentRequest {
    private String orderId;
    private String sellerId;
    private String customerId;
    private Address customerAddress;
    private Address sourceAddress;
    private Address targetAddress;
    private Double price;
    private Double weight;
    private Constants.WeightUOM weightUOM;
    private DimensionUOM dimensionUOM;
    private Double volume;
    private VolumeUOM volumeUOM;
}

