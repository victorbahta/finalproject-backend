package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String name;
    private String email;
    private String password;

    public void resetPassword() {

    }

    public void logOut() {

    }
}
