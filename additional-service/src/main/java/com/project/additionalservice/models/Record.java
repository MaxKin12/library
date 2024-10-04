package com.project.additionalservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="record")
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="book_id", unique = true, nullable = false)
    private Long bookId;
    @Column(name="take_time")
    private LocalDateTime takeTime;
    @Column(name="return_time")
    private LocalDateTime returnTime;
}

