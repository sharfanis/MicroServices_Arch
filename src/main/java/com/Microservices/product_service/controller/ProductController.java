package com.Microservices.product_service.controller;
import lombok.RequiredArgsConstructor;
import com.Microservices.product_service.dto.ProductRequest;
import com.Microservices.product_service.dto.ProductResponse;
import com.Microservices.product_service.model.Product;
import com.Microservices.product_service.service.ProductService;

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
    public void createProduct(@RequestBody ProductRequest product) {
        productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
