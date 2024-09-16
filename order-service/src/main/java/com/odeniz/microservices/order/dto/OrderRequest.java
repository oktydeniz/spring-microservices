package com.odeniz.microservices.order.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;

public record OrderRequest(
        Long id,
        String orderNumber,
        String squCode,
        BigDecimal price,
        Integer quantity,
        UserDetails userDetails
) {
}
