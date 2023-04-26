package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String status;

    Date submitDate;

    @ManyToOne
    Property property;

    @ManyToOne
    Owner owner;

    @ManyToOne
    Customer customer;

}
