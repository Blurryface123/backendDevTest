package com.example.backendDevTest.constants;

public class ErrorConstants {



    //MOCK_SERVICE
    public static final String GETSIMILARPRODUCTSID_LOG_MSG = "Failed to obtain similar products for ID: {}. Message: {}";

    public static final String GETPRODUCTDETAILBYID_LOG_MSG = "Failed to obtain product details for ID: {}. Message: {}";

    //SIMILAR_PRODUCT_SERVICE
    public static final String MOCKSERVICE_INTERNAL_ERROR_MSG = "External Api internal server error while getting similar products." +
            "Product Id: %s";

    public static final String MOCKSERVICE_TIMEOUT_ERROR_MSG ="Timeout occurred when calling the external Api";
    public ErrorConstants() {
    }
}
