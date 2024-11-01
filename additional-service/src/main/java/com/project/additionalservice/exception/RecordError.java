package com.project.additionalservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordError {
    private int statusCode;
    private String message;
}