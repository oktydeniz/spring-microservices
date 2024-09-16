package com.odeniz.microservices.product.dto;

import com.odeniz.microservices.product.model.Product;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}
