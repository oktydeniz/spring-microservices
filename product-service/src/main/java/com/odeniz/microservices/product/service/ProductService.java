package com.odeniz.microservices.product.service;

import com.odeniz.microservices.product.dto.ProductRequest;
import com.odeniz.microservices.product.dto.ProductResponse;
import com.odeniz.microservices.product.model.Product;
import com.odeniz.microservices.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest r){
        Product p = Product.builder()
                .name(r.name())
                .description(r.description())
                .price(r.price())
                .build();
        productRepository.save(p);
        log.info("Product created successfully");
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice())).toList();
    }
}
