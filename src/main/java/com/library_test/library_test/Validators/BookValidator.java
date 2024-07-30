package com.library_test.library_test.Validators;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class BookValidator {
    private Integer id;

    @NotBlank(message = "Book title is mandatory")
    @Min(value = 2, message = "Rook title must be greater than 2")
    private String title;

    @NotBlank(message = "Book author is mandatory even if it's from anonymus author")
    private String author;

    @NotBlank(message = "Book Publisher is mandatory")
    private String publisher;

    private String description;

    private LocalDate releaseDate;

}
