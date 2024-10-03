package com.project.additionalservice.repositories;

import com.project.additionalservice.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query("SELECT r FROM Record r WHERE r.takeTime is null or r.returnTime is null")
    List<Record> findAvailableBooks();
}
