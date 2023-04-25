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

    String property_type;
    String status;

    int views;

    String location;


    int room_no;

    int price;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<PropertyHistory> propertyHistoryList;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<Offer> offerList;

    @ManyToOne
    Owner owner;


}
