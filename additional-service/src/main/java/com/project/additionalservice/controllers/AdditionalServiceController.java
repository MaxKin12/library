package com.project.additionalservice.controllers;

import com.project.additionalservice.dtos.RecordNoIdsDto;
import com.project.additionalservice.models.Record;
import com.project.additionalservice.dtos.RecordDto;
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

    @GetMapping("/")
    public List<RecordDto> getAllRecords() {
        List<Record> records = recordService.findAll();
        return recordMapper.toListDto(records);
    }

    @GetMapping("/available")
    public List<RecordDto> getAvailableBooks() {
        List<Record> records = recordService.findRecordsWithAvailableBooks();
        return recordMapper.toListDto(records);
    }

    @PostMapping("/update/{id}")
    public void updateBook(@RequestBody RecordNoIdsDto recordNoIdsDto,
                                @PathVariable("id") Long bookId) {
        recordService.update(recordMapper.toNoIdsModel(recordNoIdsDto), bookId);
    }

    @PostMapping("/add")
    public void addRecord (@RequestBody Long bookId) {
        recordService.saveRecord(bookId);
    }
}
