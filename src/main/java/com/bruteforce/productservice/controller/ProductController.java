package com.bruteforce.productservice.controller;

import com.bruteforce.productservice.dto.ProductRequest;
import com.bruteforce.productservice.dto.ProductResponse;
import com.bruteforce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class that handles the endpoints for product-related operations.
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Creates a new product based on the provided product request.
     *
     * @param productRequest the request object containing the product details
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a list of product responses
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
