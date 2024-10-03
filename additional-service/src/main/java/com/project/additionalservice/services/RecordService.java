package com.project.additionalservice.services;

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
        return recordRepository.findAvailableBooks();
    }

    public Record update(Record editedRecord, Long oldBookId) {
        editedRecord.setBookId(oldBookId);
        return recordRepository.save(editedRecord);
    }

    public void saveRecord(Long bookId) {
        Record record = new Record();
        record.setBookId(bookId);
        recordRepository.save(record);
    }
}
