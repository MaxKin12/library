package com.project.additionalservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordNoIdDto {
    private LocalDateTime takeTime;
    private LocalDateTime returnTime;
}
