package com.bhagwat.scm.shipmentservice.common;

public class Constants {

    public enum WeightUOM {
        KG, LTR, GRAM
    }

    public enum DimensionUOM {
        METER, CENTIMETER, INCHES
    }

    public enum VolumeUOM {
        CUBIC_METER, CUBIC_CENTIMETER, CUBIC_INCHES, CUBIC_FEET
    }

    public enum ShipmentStatus {
        CREATED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED, RETURNED, ERROR
    }

}
