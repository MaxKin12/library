package com.project.additionalservice.controllers;

import com.project.additionalservice.dtos.RecordListDto;
import com.project.additionalservice.dtos.RecordNoIdsDto;
import com.project.additionalservice.dtos.RecordDto;
import com.project.additionalservice.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/records")
@RestController
@RequiredArgsConstructor
public class AdditionalServiceController {
    private final RecordService recordService;

    @GetMapping("")
    public ResponseEntity<RecordListDto> getAllRecords() {
        RecordListDto recordListDto = recordService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recordListDto);
    }

    @GetMapping("/available")
    public ResponseEntity<RecordListDto> getAvailableBooks() {
        RecordListDto recordListDto = recordService.findRecordsWithAvailableBooks();
        return ResponseEntity.status(HttpStatus.OK).body(recordListDto);
    }

    @PatchMapping("/{book_id}")
    public ResponseEntity<RecordDto> updateBook(@RequestBody RecordNoIdsDto recordNoIdsDto,
                                                @PathVariable("book_id") Long bookId) {
        RecordDto recordDto = recordService.update(recordNoIdsDto, bookId);
        return ResponseEntity.status(HttpStatus.OK).body(recordDto);
    }

    @PostMapping("/")
    public ResponseEntity<RecordDto> createRecord (@RequestBody Long bookId) {
        RecordDto recordDto = recordService.create(bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordDto);
    }
}
