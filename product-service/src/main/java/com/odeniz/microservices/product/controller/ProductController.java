package com.odeniz.microservices.product.controller;

import com.odeniz.microservices.product.dto.ProductRequest;
import com.odeniz.microservices.product.dto.ProductResponse;
import com.odeniz.microservices.product.model.Product;
import com.odeniz.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        /*
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
           throw new RuntimeException(e);
        }

         */
        return productService.getAllProducts();
    }
}
