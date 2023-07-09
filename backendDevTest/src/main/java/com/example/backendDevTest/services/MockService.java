package com.example.backendDevTest.services;

import com.example.backendDevTest.models.ProductDetail;

import java.util.List;

/**
 * The interface Mock service.
 */
public interface MockService {

    /**
     * Gets similar products id.
     *
     * @param id the id
     * @return the similar products id
     */
    List<Integer> getSimilarProductsId(int id);

    /**
     * Gets product detail by id.
     *
     * @param id the id
     * @return the product detail by id
     */
    ProductDetail getProductDetailById(int id);
}
