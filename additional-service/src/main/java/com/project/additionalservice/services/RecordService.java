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

    public List<Record> findAvailableRecordsWithAvailableBooks() {
        return recordRepository.findAvailableBooks();
    }

    public Record update(Record editedRecord, Long oldRecordId) {
        editedRecord.setId(oldRecordId);
        return recordRepository.save(editedRecord);
    }
}
