package com.odeniz.microservices.inventory.repository;

import com.odeniz.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySquCodeAndQuantityIsGreaterThanEqual(String squCode, Integer quantity);
}
