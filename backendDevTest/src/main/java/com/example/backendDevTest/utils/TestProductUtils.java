package com.example.backendDevTest.utils;

import com.example.backendDevTest.models.ProductDetail;

/**
 * The type Test product utils.
 */
public class TestProductUtils {


    /**
     * Create product 1 product detail.
     *
     * @return the product detail
     */
    public static ProductDetail createProduct1() {
        return ProductDetail.builder()
                .id("1")
                .name("Shirt")
                .price(9.99)
                .availability(true)
                .build();
    }

    /**
     * Create product 2 product detail.
     *
     * @return the product detail
     */
    public static ProductDetail createProduct2() {
        return ProductDetail.builder()
                .id("2")
                .name("Dress")
                .price(19.99)
                .availability(true)
                .build();
    }

    /**
     * Create product 3 product detail.
     *
     * @return the product detail
     */
    public static ProductDetail createProduct3() {
        return ProductDetail.builder()
                .id("3")
                .name("Blazer")
                .price(29.99)
                .availability(false)
                .build();
    }

    /**
     * Create product 4 product detail.
     *
     * @return the product detail
     */
    public static ProductDetail createProduct4() {
        return ProductDetail.builder()
                .id("4")
                .name("Boots")
                .price(39.99)
                .availability(true)
                .build();
    }
}
