package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import com.example.backendDevTest.services.SimilarProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Similar product service.
 */
@Slf4j
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
    public List<ProductDetail> getProductById(int productId) throws BackInvocationException, MockServiceException {

        List<Integer> productIdList = mockService.getSimilarProductsId(productId);
        return productIdList.stream()
                .map(mockService::getProductDetailById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
