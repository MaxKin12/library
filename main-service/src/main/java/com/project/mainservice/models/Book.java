package com.project.mainservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="isbn", unique = true, nullable = false, length = 17)
    private String isbn;
    @Column(name="title", nullable = false, length = 50)
    private String title;
    @Column(name="genre", length = 20)
    private String genre;
    @Column(name="description", length = 200)
    private String description;
    @Column(name="author", length = 50)
    private String author;
}
