package com.library_test.library_test;

import com.library_test.library_test.Validators.UserValidator;
import com.library_test.library_test.services.UserService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void whenPasswordTooShert_thenThrowsException(){
        UserValidator user = new UserValidator();
        user.setUsername("testuser");
        user.setPassword("short");

        assertThrows(ConstraintViolationException.class, () -> {
            service.createNewUser(user);
        });
    }
}
