package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
enum PropertyType{
    CONDO,
    DUPLEX,
    HOUSE
}
enum Status{
    AVAILABLE,
    PENDING,
    CONTINGENT,
    SOLD

}
@Data
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    PropertyType property_type;
    Status status;

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
