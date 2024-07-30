package com.library_test.library_test.Validators;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class BookValidator {
    @NotBlank(message = "Book title is mandatory")
    private String title;

    @NotBlank(message = "Book author is mandatory even if it's from anonymus author")
    private String author;

    @NotBlank(message = "Book Publisher is mandatory")
    private String publisher;

    private String description;

    private LocalDate releaseDate;

}
