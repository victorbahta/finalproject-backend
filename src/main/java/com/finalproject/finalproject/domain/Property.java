package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    String listing_type; // sale or rent

    int views;

    String location;


    int room_no;

    int price;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    List<PropertyHistory> propertyHistoryList;

//    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//
//    List<Offer> offerList;

    @ManyToOne
            @JsonBackReference
    Owner owner;


}
