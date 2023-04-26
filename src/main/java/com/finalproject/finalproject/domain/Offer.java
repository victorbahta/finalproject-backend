package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    LocalDate submitDate;

    @ManyToOne
    Property property;

    @ManyToOne
    Owner owner;

    @ManyToOne
            @JsonBackReference
    Customer customer;

}
