package com.bhagwat.scm.shipmentservice.handler;


import com.bhagwat.scm.shipmentservice.dto.ShipmentCreatedEvent;
import com.bhagwat.scm.shipmentservice.entity.Shipment;
import com.bhagwat.scm.shipmentservice.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentEventHandler {

    private final ShipmentRepository shipmentRepository;

    @EventHandler
    public void on(ShipmentCreatedEvent event) {
        Shipment shipment = new Shipment();
        shipment.setShipmentId(event.getShipmentId());
        shipment.setOrderId(event.getOrderId());
        shipment.setSellerId(event.getSellerId());
        shipment.setCustomerId(event.getCustomerId());
        shipment.setCustomerAddress(event.getCustomerAddress());
        shipment.setSourceAddress(event.getSourceAddress());
        shipment.setTargetAddress(event.getTargetAddress());
        shipment.setStatus(event.getStatus());
        shipment.setPrice(event.getPrice());
        shipment.setWeight(event.getWeight());
        shipment.setWeightUOM(event.getWeightUOM());
        shipment.setDimensionUOM(event.getDimensionUOM());
        shipment.setVolume(event.getVolume());
        shipment.setVolumeUOM(event.getVolumeUOM());
        shipment.setShipmentCreatedDate(new java.util.Date());
        shipmentRepository.save(shipment);
    }
}

