package com.project.additionalservice.dto;

import java.time.LocalDateTime;

public record RecordDto (
        Long id,
        Long bookId,
        LocalDateTime takeTime,
        LocalDateTime returnTime
) {}
