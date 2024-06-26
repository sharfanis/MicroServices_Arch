package com.Microservices.product_service.service;

import com.Microservices.product_service.dto.ProductRequest;
import com.Microservices.product_service.dto.ProductResponse;
import com.Microservices.product_service.model.Product;
import com.Microservices.product_service.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

         productRepository.save(product);
         log.info("product {} is saved", product.getId());
    }


    public List<ProductResponse > getAllProducts() {
        List<Product> products = productRepository.findAll();
        // Now I have use map to convert product class into product response
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

        ProductResponse productResponse =  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

        return productResponse;

    }
}
