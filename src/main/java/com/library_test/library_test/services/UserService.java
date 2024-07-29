package com.library_test.library_test.services;

import com.library_test.library_test.Validators.UserValidator;
import com.library_test.library_test.models.User;
import com.library_test.library_test.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;


    public UserService(UserRepository repo, PasswordEncoder encoder){
        this.repo = repo;
        this.encoder = encoder;
    }

    public User createNewUser(UserValidator newUser){
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(encoder.encode(newUser.getPassword()));
        return this.repo.save(user);
    }

    public boolean correctCredentials(String username, String password){
        User user = this.repo.findByUsername(username);
        if(user == null) return false;
        return this.encoder.matches(password, user.getPassword());
    }

}
