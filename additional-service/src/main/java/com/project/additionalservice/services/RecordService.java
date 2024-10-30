package com.project.additionalservice.services;

import com.project.additionalservice.exceptions.DBException;
import com.project.additionalservice.exceptions.ResourceNotFoundException;
import com.project.additionalservice.models.Record;
import com.project.additionalservice.repositories.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    public final RecordRepository recordRepository;

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public List<Record> findRecordsWithAvailableBooks() {
        return recordRepository.findAvailableBooks().orElseThrow(()-> new ResourceNotFoundException("No available books"));
    }

    public void update(Record editedRecord, Long oldBookId) {
        recordRepository.findByBookId(oldBookId).orElseThrow(()-> new ResourceNotFoundException("Record with book id " +
                oldBookId + " not found"));
        recordRepository.updateRecordInfoByBookId(
                oldBookId,
                editedRecord.getTakeTime(),
                editedRecord.getReturnTime()
        );
    }

    public void saveRecord(Long bookId) {
        Record record = new Record();
        record.setBookId(bookId);
        try {
            recordRepository.save(record);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
