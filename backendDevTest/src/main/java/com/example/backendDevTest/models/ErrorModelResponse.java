package com.example.backendDevTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModelResponse {
    private int statusCode;
    private String statusText;
    private String detailMessage;
}
