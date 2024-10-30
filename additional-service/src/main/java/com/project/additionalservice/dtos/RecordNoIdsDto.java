package com.project.additionalservice.dtos;

import java.time.LocalDateTime;

public record RecordNoIdsDto (
        LocalDateTime takeTime,
        LocalDateTime returnTime
) {}
