package com.library_test.library_test.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserCredentials {
    private String username;
    private String password;
}
