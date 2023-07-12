package com.example.backendDevTest.web;

import com.example.backendDevTest.constants.HttpConstants;
import com.example.backendDevTest.exception.BackInvocationException;
import com.example.backendDevTest.exception.MockServiceException;
import com.example.backendDevTest.models.ErrorModelResponse;
import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.SimilarProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpConstants.OK, description = HttpConstants.OK_DESC),
            @ApiResponse(responseCode = HttpConstants.BAD_REQUEST_CODE, description = HttpConstants.BAD_REQUEST_DESC,
                    content = @Content(schema = @Schema(implementation = ErrorModelResponse.class))),
            @ApiResponse(responseCode = HttpConstants.NOT_FOUND_CODE, description = HttpConstants.NOT_FOUND_DESC,
                    content = @Content(schema = @Schema(implementation = ErrorModelResponse.class))),
            @ApiResponse(responseCode = HttpConstants.INTERNAL_SERVER_CODE, description = HttpConstants.INTERNAL_SERVER_DESC,
                    content = @Content(schema = @Schema(implementation = ErrorModelResponse.class)))
    })
    @GetMapping(value = "/product/{productId}/similar",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@PathVariable("productId")
                                                                    @Schema(example = "1")
                                                                      int productId) throws BackInvocationException, MockServiceException {
        return ResponseEntity.status(HttpStatus.OK).body(similarProductService.getProductById(productId));
    }


}
