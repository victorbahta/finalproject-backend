package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String msg;
    @OneToOne
            @JsonIgnore
    Owner owner;
    @OneToOne
    Customer customer;
    @OneToOne
    Property property;
}
