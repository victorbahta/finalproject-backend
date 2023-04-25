package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user") // , fetch = FetchType.LAZY
//    @JsonManagedReference
//    @Fetch(FetchMode.SELECT)
//    //@JoinColumn(name = "user_id")
//    @JsonIgnore
//    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
