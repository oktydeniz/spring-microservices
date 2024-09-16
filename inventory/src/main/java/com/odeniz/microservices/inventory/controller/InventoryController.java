package com.odeniz.microservices.inventory.controller;

import com.odeniz.microservices.inventory.service.InventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String squCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(squCode, quantity);
    }
}
