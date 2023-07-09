package com.example.backendDevTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product detail.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    private String id;
    private String name;
    private double price;
    private boolean availability;

}
