package com.library_test.library_test.Validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserValidator {
    private Integer id;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, message = "Password must be at least 3 characters long")
    private String username;

    @NotBlank(message = "password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
