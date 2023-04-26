package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String name;
    private String email;
    private String password;
    private String role;

    public void resetPassword() {

    }

    public void logOut() {

    }
}
