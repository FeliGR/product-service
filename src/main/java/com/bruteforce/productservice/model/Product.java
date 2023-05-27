package com.bruteforce.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Represents a product entity.
 */
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    /**
     * The unique identifier of the product.
     */
    @Id
    private String id;

    /**
     * The name of the product.
     */
    private String name;
    /**
     * The description of the product.
     */
    private String description;
    /**
     * The price of the product.
     */
    private BigDecimal price;
}
