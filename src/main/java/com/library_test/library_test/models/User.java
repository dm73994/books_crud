package com.library_test.library_test.models;

import jakarta.persistence.*;

import lombok.Data;



@Entity
@Data
@Table(name = "library_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

}
