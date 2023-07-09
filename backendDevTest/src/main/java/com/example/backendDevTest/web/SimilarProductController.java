package com.example.backendDevTest.web;

import com.example.backendDevTest.models.ProductDetail;
import com.example.backendDevTest.services.SimilarProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@PathVariable("productId") int productId){
        return ResponseEntity.status(HttpStatus.OK).body(similarProductService.getProductById(productId));
    }
}
