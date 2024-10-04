package com.project.additionalservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordNoIdsDto {
    private LocalDateTime takeTime;
    private LocalDateTime returnTime;
}
