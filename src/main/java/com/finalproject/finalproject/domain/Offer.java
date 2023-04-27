package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String status;

    double amount;

    String message;

    LocalDate submitDate;

    @ManyToOne
    Property property;

    @ManyToOne
            @JsonIgnore
    Owner owner;

    @ManyToOne
            @JsonBackReference
    Customer customer;

}
