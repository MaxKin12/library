package com.project.additionalservice.service;

import com.project.additionalservice.dto.RecordDto;
import com.project.additionalservice.dto.RecordListDto;
import com.project.additionalservice.dto.RecordNoIdsDto;
import com.project.additionalservice.exception.DBException;
import com.project.additionalservice.exception.ResourceNotFoundException;
import com.project.additionalservice.mapper.RecordMapper;
import com.project.additionalservice.model.Record;
import com.project.additionalservice.repository.RecordRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class RecordService {
    public final RecordRepository recordRepository;
    public final RecordMapper recordMapper;

    public RecordListDto findAll() {
        List<Record> records = recordRepository.findAll();
        return recordMapper.toRecordListDto(records);
    }

    public RecordListDto findRecordsWithAvailableBooks() {
        List<Record> records = recordRepository.findAvailableBooks()
                .orElseThrow(()-> new ResourceNotFoundException("No available books"));
        return recordMapper.toRecordListDto(records);
    }

    @Transactional
    public RecordDto update(RecordNoIdsDto editedRecord,
                            @Positive(message = "id must be positive number") Long oldBookId) {
        Record record = recordRepository.findByBookId(oldBookId)
                .orElseThrow(()-> new ResourceNotFoundException("Record with book id " + oldBookId + " not found"));
        try {
            record.setTakeTime(editedRecord.takeTime());
            record.setReturnTime(editedRecord.returnTime());
            return recordMapper.toDto(record);
        } catch (Exception e) {
            throw new DBException("Invalid attempt to update record");
        }
    }

    public RecordDto create(@Positive(message = "id must be positive number") Long bookId) {
        Record record = new Record();
        record.setBookId(bookId);
        try {
            recordRepository.save(record);
            return recordMapper.toDto(record);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
