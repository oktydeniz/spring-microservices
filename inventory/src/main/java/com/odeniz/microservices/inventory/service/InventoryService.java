package com.odeniz.microservices.inventory.service;


import com.odeniz.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String squCode, Integer quantity) {

        return inventoryRepository.existsBySquCodeAndQuantityIsGreaterThanEqual(squCode, quantity);
    }
}
