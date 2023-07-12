package com.example.backendDevTest.services;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
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
    List<Integer> getSimilarProductsId(int id) throws BackInvocationException, MockServiceException;

    /**
     * Gets product detail by id.
     *
     * @param id the id
     * @return the product detail by id
     */
    ProductDetail getProductDetailById(int id);
}
