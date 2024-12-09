package com.bhagwat.scm.shipmentservice.controller;

import com.bhagwat.scm.shipmentservice.entity.Shipment;
import com.bhagwat.scm.shipmentservice.query.FindAllShipmentsQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentQueryController {

    private final QueryGateway queryGateway;

    public ShipmentQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return queryGateway.query(new FindAllShipmentsQuery(), ResponseTypes.multipleInstancesOf(Shipment.class)).join();
    }
}

