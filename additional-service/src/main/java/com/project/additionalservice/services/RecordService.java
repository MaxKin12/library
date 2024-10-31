package com.project.additionalservice.services;

import com.project.additionalservice.dtos.RecordDto;
import com.project.additionalservice.dtos.RecordListDto;
import com.project.additionalservice.dtos.RecordNoIdsDto;
import com.project.additionalservice.exceptions.DBException;
import com.project.additionalservice.exceptions.ResourceNotFoundException;
import com.project.additionalservice.mappers.RecordMapper;
import com.project.additionalservice.models.Record;
import com.project.additionalservice.repositories.RecordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public RecordDto update(RecordNoIdsDto editedRecord, Long oldBookId) {
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

    public RecordDto create(Long bookId) {
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
