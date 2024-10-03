package com.project.additionalservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordDto {
    private Long id;
    private Long bookId;
    private LocalDateTime takeTime;
    private LocalDateTime returnTime;
}
