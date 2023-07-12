package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.constants.CacheableConstants;
import com.example.backendDevTest.constants.ErrorConstants;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

/**
 * The type Mock service.
 */
@Slf4j
@Service
public class MockServiceImpl implements MockService {

    private final WebClient webClient;

    /**
     * Instantiates a new Mock service.
     */
    @Autowired
    public MockServiceImpl() {
        this.webClient = WebClient.create("http://localhost:3001");
    }

    @Override
    @Cacheable(CacheableConstants.SIMILARPRODUCTSID)
    public List<Integer> getSimilarProductsId(int id) throws  MockServiceException {
        try {
            return webClient.get()
                    .uri("/product/{id}/similarids",id)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Integer>>() {
                    })
                    .block();
        }catch (WebClientResponseException e){
            log.error(ErrorConstants.GETSIMILARPRODUCTSID_LOG_MSG,
                    id,e.getStatusCode(),e.getMessage());
            throw new MockServiceException(
                    String.format(ErrorConstants.GETSIMILARPRODUCTSID_METHOD_NAME,
                            ErrorConstants.GETSIMILARPRODUCTSID_METHOD_MSG)
                    ,e);
        }

    }

    @Override
    @Cacheable(CacheableConstants.PRODUCTDETAILS)
    public ProductDetail getProductDetailById(int id) {
        try {
            return webClient.get()
                    .uri("/product/{id}",id)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<ProductDetail>() {
                    })
                    .block();
        }catch (WebClientResponseException e){
            log.error(ErrorConstants.GETPRODUCTDETAILBYID_LOG_MSG,
                    id,e.getStatusCode(),e.getMessage());
            return null;
        }
    }
}
