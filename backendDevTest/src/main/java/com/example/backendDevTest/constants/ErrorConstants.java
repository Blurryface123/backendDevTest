package com.example.backendDevTest.constants;

public class ErrorConstants {



    //MOCK_SERVICE
    public static final String GETSIMILARPRODUCTSID_METHOD_NAME = "getSimilarProductsId: %s";
    public static final String GETSIMILARPRODUCTSID_METHOD_MSG = "Failed to obtain ids";

    public static final String GETSIMILARPRODUCTSID_LOG_MSG = "Failed to obtain similar products for ID: {}. Status code:{}. Message: {}";

    public static final String GETPRODUCTDETAILBYID_LOG_MSG = "Failed to obtain product details for ID: {}. Status code:{}. Message: {}";

    //SIMILAR_PRODUCT_SERVICE
    public static final String GETPRODUCTBYID_LOG_MSG = "Failed while building the product detail List for ProductId: {}. Message: {}";

    public static final String GETPRODUCTBYID_METHOD_MSG = "Failed while building the product detail List";

    public ErrorConstants() {
    }
}
