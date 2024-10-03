package com.project.additionalservice.controllers;

import com.project.additionalservice.models.Record;
import com.project.additionalservice.dtos.RecordDto;
import com.project.additionalservice.dtos.RecordNoIdDto;
import com.project.additionalservice.mappers.RecordMapper;
import com.project.additionalservice.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdditionalServiceController {
    private final RecordMapper recordMapper;
    private final RecordService recordService;

    @GetMapping("/available")
    public List<RecordDto> getAvailableBooks() {
        List<Record> records = recordService.findAvailableRecordsWithAvailableBooks();
        return recordMapper.toListDto(records);
    }

    @PostMapping("/update/{id}")
    public RecordDto updateBook(@RequestBody RecordNoIdDto recordNoIdDto,
                                @PathVariable("id") Long recordId) {
        Record record = recordService.update(recordMapper.toNoIdModel(recordNoIdDto), recordId);
        return recordMapper.toDto(record);
    }
}
