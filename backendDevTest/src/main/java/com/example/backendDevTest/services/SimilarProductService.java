package com.example.backendDevTest.services;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;

import java.util.List;

/**
 * The interface Similar product service.
 */
public interface SimilarProductService {

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    List<ProductDetail> getProductById(int productId) throws BackInvocationException, MockServiceException;
}
