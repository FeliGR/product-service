package com.bruteforce.productservice.repository;

import com.bruteforce.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface that handles product-related operations.
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
