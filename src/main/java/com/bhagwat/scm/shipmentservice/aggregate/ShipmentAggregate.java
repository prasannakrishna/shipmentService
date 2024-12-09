package com.bhagwat.scm.shipmentservice.aggregate;


import com.bhagwat.scm.shipmentservice.common.Constants;
import com.bhagwat.scm.shipmentservice.dto.CreateShipmentCommand;
import com.bhagwat.scm.shipmentservice.dto.ShipmentCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class ShipmentAggregate {

    @AggregateIdentifier
    private String shipmentId;
    private Constants.ShipmentStatus status;

    @CommandHandler
    public ShipmentAggregate(CreateShipmentCommand command) {
        apply(new ShipmentCreatedEvent(
                command.getShipmentId(),
                command.getOrderId(),
                command.getSellerId(),
                command.getCustomerId(),
                command.getCustomerAddress(),
                command.getSourceAddress(),
                command.getTargetAddress(),
                command.getStatus(),
                command.getPrice(),
                command.getWeight(),
                command.getWeightUOM(),
                command.getDimensionUOM(),
                command.getVolume(),
                command.getVolumeUOM()
        ));
    }

    @EventSourcingHandler
    public void on(ShipmentCreatedEvent event) {
        this.shipmentId = event.getShipmentId();
        this.status = event.getStatus();
    }
}

