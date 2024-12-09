package com.bhagwat.scm.shipmentservice.handler;

import com.bhagwat.scm.shipmentservice.entity.Shipment;
import com.bhagwat.scm.shipmentservice.query.FindAllShipmentsQuery;
import com.bhagwat.scm.shipmentservice.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShipmentQueryHandler {

    private final ShipmentRepository shipmentRepository;

    @QueryHandler
    public List<Shipment> handle(FindAllShipmentsQuery query) {
        return shipmentRepository.findAll();
    }
}

