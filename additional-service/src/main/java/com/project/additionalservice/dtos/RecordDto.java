package com.project.additionalservice.dtos;

import java.time.LocalDateTime;

public record RecordDto (
        Long id,
        Long bookId,
        LocalDateTime takeTime,
        LocalDateTime returnTime
) {}
