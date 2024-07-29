package com.library_test.library_test.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Book title is mandatory")
    @Min(value = 2, message = "Rook title must be greater than 2")
    private String title;

    @NotBlank(message = "Book author is mandatory even if it's from anonymus author")
    private String author;

    @NotBlank(message = "Book Publisher is mandatory")
    private String publisher;

    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

}
