package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    enum Status{
        AVAILABLE,
        PENDING,
        CONTINGENT,
        SOLD

    }

    int views;

    String location;
    enum PropertyType{
        CONDO,
        DUPLEX,
        HOUSE
    }

    int roomNo;

    int price;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<PropertyHistory> propertyHistoryList;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<Offer> offerList;

    @ManyToOne
    Owner owner;


}
