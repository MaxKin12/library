package com.project.gatewayservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GatewayError {
    private int statusCode;
    private String message;
}