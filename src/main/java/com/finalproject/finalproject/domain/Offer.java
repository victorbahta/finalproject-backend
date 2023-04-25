package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String status;

    @ManyToOne
    Property property;

    @ManyToOne
    Owner owner;

    @ManyToOne
    Customer customer;

}
