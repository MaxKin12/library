package com.project.additionalservice.repositories;

import com.project.additionalservice.models.Record;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByBookId(Long bookId);
    @Query("select r from Record r where r.takeTime is null or r.returnTime is null")
    Optional<List<Record>> findAvailableBooks();
    @Modifying
    @Transactional
    @Query("update Record r set r.takeTime = ?2, r.returnTime = ?3 where r.bookId = ?1")
    void updateRecordInfoByBookId(Long bookId, LocalDateTime takeTime, LocalDateTime returnTime);
}
