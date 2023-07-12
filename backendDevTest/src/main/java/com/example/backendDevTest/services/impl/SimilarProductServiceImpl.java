package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.constants.ErrorConstants;
import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import com.example.backendDevTest.services.SimilarProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

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
        try{
            List<ProductDetail> productDetailList = new ArrayList<>();
            List<Integer> productIdList = mockService.getSimilarProductsId(productId);
            productIdList.forEach(id-> {
                        ProductDetail productDetail = mockService.getProductDetailById(id);
                        if (productDetail!=null){
                            productDetailList.add(productDetail);
                        }
                    }
            );
            return productDetailList;
        }catch (Exception e){
            if (!(e.getCause() instanceof WebClientResponseException)){
                log.error(ErrorConstants.GETPRODUCTBYID_LOG_MSG,productId, e.getMessage());
                throw new BackInvocationException(ErrorConstants.GETPRODUCTBYID_METHOD_MSG,e);
            }
            throw new MockServiceException(ErrorConstants.GETSIMILARPRODUCTSID_METHOD_MSG,e);
        }

    }
}
