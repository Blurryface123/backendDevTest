package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.MockService;
import com.example.backendDevTest.utils.TestProductUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SimilarProductServiceImplTest {

    @InjectMocks
    private SimilarProductServiceImpl similarProductService;

    @Mock
    private MockService mockService;

    @Test
    void getProductById_returnExpectedDetailList() throws BackInvocationException, MockServiceException {
        //given
        int productId = 1;
        List<Integer> mockProductIdList = Arrays.asList(2,3,4);
        List<ProductDetail> expectedDetailList = Arrays.asList(
                TestProductUtils.createProduct2(),TestProductUtils.createProduct3(),TestProductUtils.createProduct4()
        );

        given(mockService.getSimilarProductsId(productId)).willReturn(mockProductIdList);
        given(mockService.getProductDetailById(2)).willReturn(TestProductUtils.createProduct2());
        given(mockService.getProductDetailById(3)).willReturn(TestProductUtils.createProduct3());
        given(mockService.getProductDetailById(4)).willReturn(TestProductUtils.createProduct4());

        //when
        List<ProductDetail> productDetailList = similarProductService.getProductById(1);

        //then
        assertEquals(expectedDetailList,productDetailList);
    }
}