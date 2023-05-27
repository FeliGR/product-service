package com.bruteforce.productservice.service;

import com.bruteforce.productservice.dto.ProductRequest;
import com.bruteforce.productservice.dto.ProductResponse;
import com.bruteforce.productservice.model.Product;
import com.bruteforce.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that handles product-related operations.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Creates a new product based on the provided product request.
     *
     * @param productRequest the request object containing the product details
     */
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a list of product responses
     */
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    /**
     * Maps a product entity to its corresponding response DTO.
     *
     * @param product the product entity to be mapped
     * @return the mapped product response DTO
     */
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
