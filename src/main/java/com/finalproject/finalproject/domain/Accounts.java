package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate createdDate;
    private String status;
    private byte[] image;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    public void resetPassword() {

    }

    public void logOut() {

    }
}
