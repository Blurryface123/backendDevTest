package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * The type Mock service.
 */
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
    public List<Integer> getSimilarProductsId(int id) {
        return webClient.get()
                .uri("/product/{id}/similarids",id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Integer>>() {
                })
                .block();
    }

    @Override
    public ProductDetail getProductDetailById(int id) {
        return webClient.get()
                .uri("/product/{id}",id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ProductDetail>() {
                })
                .block();
    }
}
