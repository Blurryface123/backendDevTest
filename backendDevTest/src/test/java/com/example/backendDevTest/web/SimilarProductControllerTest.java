package com.example.backendDevTest.web;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.SimilarProductService;
import com.example.backendDevTest.utils.TestProductUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimilarProductControllerTest {

    @Mock
    public SimilarProductService similarProductService;

    @InjectMocks
    public SimilarProductController similarProductController;



    @Test
    void getSimilarProducts_returnExpectedProducts() throws BackInvocationException, MockServiceException {
        //given
        int productId = 1;
        List<ProductDetail> expectedProducts = new ArrayList<>();
        expectedProducts.add(TestProductUtils.createProduct2());
        expectedProducts.add(TestProductUtils.createProduct3());
        expectedProducts.add(TestProductUtils.createProduct4());

        when(similarProductService.getProductById(productId)).thenReturn(expectedProducts);

        //when
        ResponseEntity<List<ProductDetail>> response = similarProductController.getSimilarProducts(productId);

        //then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(),expectedProducts);
    }

    @Test
    public void getSimilarProducts_MockServiceException() throws BackInvocationException {
        //give
        int productId  = 1;

        //when
        assertThrows(MockServiceException.class, () -> {
            when(similarProductService.getProductById(productId)).thenThrow(new MockServiceException());
            ResponseEntity<List<ProductDetail>> response = similarProductController.getSimilarProducts(productId);
            assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
        });
    }

    @Test
    public void getSimilarProducts_BackInvocationException() throws MockServiceException {
        //give
        int productId  = 1;

        //when
        assertThrows(BackInvocationException.class, () -> {
            when(similarProductService.getProductById(productId)).thenThrow(new BackInvocationException());
            ResponseEntity<List<ProductDetail>> response = similarProductController.getSimilarProducts(productId);
            assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        });
    }
}