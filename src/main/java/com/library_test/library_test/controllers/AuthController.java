package com.library_test.library_test.controllers;

import com.library_test.library_test.Validators.UserValidator;
import com.library_test.library_test.models.User;
import com.library_test.library_test.models.UserCredentials;
import com.library_test.library_test.services.TokenService;
import com.library_test.library_test.services.UserService;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final TokenService tokenService;

    public AuthController(UserService userService, TokenService tokenService){
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    @Timed(value = "Post.registerUser.time", description = "Time taken to execute post endpoint to register a new User")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserValidator newUser){
        User user = this.userService.createNewUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @Timed(value = "Post.login.time", description = "Time taken to execute post endpoint to get token for authentication")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        boolean validUser = this.userService.correctCredentials(credentials.getUsername(), credentials.getPassword());

        if(validUser){
            return new ResponseEntity<>(tokenService.generateToken(credentials), HttpStatus.OK);
        }
        return new ResponseEntity<>("BAD CREDENTIALS", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
