package com.example.backendDevTest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Error model response.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModelResponse {
    private int statusCode;
    private String statusText;
    private String message;
}
