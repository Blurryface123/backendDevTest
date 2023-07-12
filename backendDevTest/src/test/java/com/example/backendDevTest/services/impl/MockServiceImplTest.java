package com.example.backendDevTest.services.impl;

import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.utils.TestProductUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MockServiceImplTest {

    @InjectMocks
    private MockServiceImpl mockService;

    @Mock
    private WebTestClient webTestClient;


    @BeforeEach
    public void setup() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://host.docker.internal:3001")  // Establece la URL base del endpoint externo
                .responseTimeout(Duration.ofMillis(999))
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    public void testGetSimilarProductsId_returnsimilarProductsIds() {
        // given
        List<Integer> expectedIds = Arrays.asList(2, 3, 4);

        // when
        webTestClient.get().uri("/product/{id}/similarids", 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(actualIds -> {
                    //then
                    assertEquals(expectedIds, actualIds);
                });
    }

    @Test
    public void testGetProductDetailById_returnExpectedProductDetail() {
        webTestClient.get().uri("/product/{id}", 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductDetail.class)
                .value(actualDetail -> {
                    //then
                    assertEquals(TestProductUtils.createProduct1(), actualDetail);
                });
    }


    @Test
    public void testGetProductDetailById_returnsNotFound() {
        int id = 5;
        webTestClient.get().uri("/product/{id}", id)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void testGetProductDetailById_returnsInternalServerError() {
        // given
        int id = 6;

        // when and then
        webTestClient.get().uri("/product/{id}", id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Test
    public void testGetProductDetailById_timeout() {
        // given
        int id = 1000;

        // when and then
        assertThrows(IllegalStateException.class, () -> {
            webTestClient.get().uri("/product/{id}", id)
                    .exchange();
        });

    }

}