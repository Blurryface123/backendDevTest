package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.constants.CacheableConstants;
import com.example.backendDevTest.constants.ErrorConstants;
import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.CustomTimeoutException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ErrorModelResponse;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * The type Mock service.
 */
@Slf4j
@Service
public class MockServiceImpl implements MockService {

    private final WebClient webClient;

    @Value("${rest.existing-apis.base-url}")
    private String BASE_URL;

    @Value("${rest.existing-apis.similarId}")
    private String SIMILAR_ID;


    /**
     * Instantiates a new Mock service.
     */
    @Autowired
    public MockServiceImpl() {
        this.webClient = WebClient.create("http://host.docker.internal:3001/product/");
    }

    @Override
    @Cacheable(CacheableConstants.SIMILARPRODUCTSID)
    public List<Integer> getSimilarProductsId(int id){
            return webClient.get()
                    .uri(BASE_URL+id+SIMILAR_ID)
                    .retrieve()
                    .onStatus(HttpStatus ->HttpStatus.is4xxClientError(), response -> handleMockExceptionPlainTextError(response,id))
                    .onStatus(HttpStatus->HttpStatus.is5xxServerError(), response -> handleBackInvocationException(id))
                    .bodyToMono(new ParameterizedTypeReference<List<Integer>>() {
                    })
                    .timeout(Duration.ofSeconds(3L))
                    .block();

    }

    @Override
    @Cacheable(CacheableConstants.PRODUCTDETAILS)
    public ProductDetail getProductDetailById(int id) {
            return webClient.get()
                    .uri(String.valueOf(id))
                    .retrieve()
                    .onStatus(HttpStatus ->HttpStatus.is4xxClientError(), response -> handleMockExceptionJsonError(response,id))
                    .onStatus(HttpStatus->HttpStatus.is5xxServerError(), response -> handleBackInvocationException(id))
                    .bodyToMono(new ParameterizedTypeReference<ProductDetail>() {
                    })
                    .timeout(Duration.ofSeconds(3L))
                    .onErrorResume(TimeoutException.class, e -> handleMockTimeoutException(e))
                    .block();
    }

    /**
     * Handles the MockException when the respponse is in a json format
     * @param response the response
     * @param id the id
     * @return a new MockServiceException
     */
    private Mono<? extends Throwable> handleMockExceptionJsonError(ClientResponse response, int id) {
        return response.bodyToMono(ErrorModelResponse.class)
                .flatMap(errorModelResponse -> {
                    log.error(ErrorConstants.GETPRODUCTDETAILBYID_LOG_MSG,id, errorModelResponse.getMessage());
                    return Mono.error(new MockServiceException(errorModelResponse.getMessage()));
                });
    }

    /**
     * Handles the MockException when the respponse is in a text format
     * @param response the response
     * @param id the id
     * @return a new MockServiceException
     */
    private Mono<? extends Throwable> handleMockExceptionPlainTextError(ClientResponse response, int id) {
        return response.bodyToMono(String.class)
                .flatMap(errorModelResponse -> {
                    ErrorModelResponse err = ErrorModelResponse.builder().message(errorModelResponse).build();
                    log.error(ErrorConstants.GETSIMILARPRODUCTSID_LOG_MSG,id, err.getMessage());
                    return Mono.error(new MockServiceException(err.getMessage()));
                });
    }

    /**
     * Handles the BackInvocationException from the webclient
     * @param id the id
     * @return a new BackInvocationException
     */
    private Mono<? extends Throwable> handleBackInvocationException(int id) {
        log.error(String.format(ErrorConstants.MOCKSERVICE_INTERNAL_ERROR_MSG,id));
        return Mono.error(new BackInvocationException(String.format(ErrorConstants.MOCKSERVICE_INTERNAL_ERROR_MSG,id)));
    }

    /**
     * Handles the TimeoutException from the webclient
     * @param e the exception
     * @return a new CustomTimeoutException
     */
    private <T> Mono<T> handleMockTimeoutException(Throwable e) {
        log.error(ErrorConstants.MOCKSERVICE_TIMEOUT_ERROR_MSG);
        throw new CustomTimeoutException(ErrorConstants.MOCKSERVICE_TIMEOUT_ERROR_MSG, e);
    }
}