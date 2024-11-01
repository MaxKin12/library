package com.project.additionalservice.repository;

import com.project.additionalservice.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByBookId(Long bookId);
    @Query("select r from Record r where r.takeTime is null or r.returnTime is null")
    Optional<List<Record>> findAvailableBooks();
}
