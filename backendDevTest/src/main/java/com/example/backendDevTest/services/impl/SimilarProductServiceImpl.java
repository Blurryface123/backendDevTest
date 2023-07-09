package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import com.example.backendDevTest.services.SimilarProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Similar product service.
 */
@Service
public class SimilarProductServiceImpl implements SimilarProductService {

    /**
     * The Mock service.
     */
    public MockService mockService;

    /**
     * Instantiates a new Similar product service.
     *
     * @param mockService the mock service
     */
    @Autowired
    public SimilarProductServiceImpl(MockService mockService) {
        this.mockService = mockService;
    }

    @Override
    public List<ProductDetail> getProductById(int productId) {
        List<ProductDetail> productDetailList = new ArrayList<>();
        List<Integer> productIdList = mockService.getSimilarProductsId(productId);
        productIdList.forEach(id->
            productDetailList.add(mockService.getProductDetailById(id))
        );
        return productDetailList;
    }
}
