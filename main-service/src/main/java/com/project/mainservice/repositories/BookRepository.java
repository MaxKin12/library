package com.project.mainservice.repositories;

import com.project.mainservice.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    @Modifying
    @Transactional
    @Query("update Book b set b.isbn = ?2, b.title = ?3, b.genre = ?4, b.description = ?5, b.author = ?6 where b.id = ?1")
    void updateRecordInfoByBookId(Long bookId, String isbn, String title, String genre, String description, String author);
}
