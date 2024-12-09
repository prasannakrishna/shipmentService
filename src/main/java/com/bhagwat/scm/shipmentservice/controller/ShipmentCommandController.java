package com.bhagwat.scm.shipmentservice.controller;

import com.bhagwat.scm.shipmentservice.common.Constants;
import com.bhagwat.scm.shipmentservice.dto.CreateShipmentCommand;
import com.bhagwat.scm.shipmentservice.dto.ShipmentRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentCommandController {

    private final CommandGateway commandGateway;

    public ShipmentCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createShipment(@RequestBody ShipmentRequest request) {
        String shipmentId = UUID.randomUUID().toString();
        commandGateway.send(new CreateShipmentCommand(
                shipmentId,
                request.getOrderId(),
                request.getSellerId(),
                request.getCustomerId(),
                request.getCustomerAddress(),
                request.getSourceAddress(),
                request.getTargetAddress(),
                Constants.ShipmentStatus.CREATED,
                request.getPrice(),
                request.getWeight(),
                request.getWeightUOM(),
                request.getDimensionUOM(),
                request.getVolume(),
                request.getVolumeUOM()
        ));
        return shipmentId;
    }
}


