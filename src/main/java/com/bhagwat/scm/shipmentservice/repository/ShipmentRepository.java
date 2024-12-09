package com.bhagwat.scm.shipmentservice.repository;

import com.bhagwat.scm.shipmentservice.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
}
