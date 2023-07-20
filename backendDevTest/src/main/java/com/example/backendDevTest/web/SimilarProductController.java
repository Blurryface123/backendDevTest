package com.example.backendDevTest.web;

import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.SimilarProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Similar product controller.
 */
@RestController
@RequestMapping("/api")
public class SimilarProductController{

    /**
     * The Similar product service.
     */
    @Autowired
    public SimilarProductService similarProductService;


    /**
     * Gets similar products.
     *
     * @param productId the product id
     * @return the similar products
     */
    @Operation(summary = "Returns a list of similar products details for a given product id")
    @GetMapping(value = "/product/{productId}/similar",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@PathVariable("productId")
                                                                  @Schema(example = "1")
                                                                  @Min(1)
                                                                  @Max(6)
                                                                  @NotBlank
                                                                  @Positive
                                                                  int productId) throws BackInvocationException,
                                                                    MockServiceException {
        return ResponseEntity.status(HttpStatus.OK).body(similarProductService.getProductById(productId));
    }


}
