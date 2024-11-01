package com.project.additionalservice.dto;

import java.time.LocalDateTime;

public record RecordNoIdsDto (
        LocalDateTime takeTime,
        LocalDateTime returnTime
) {}
