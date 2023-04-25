package com.finalproject.finalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer extends Accounts {

    @OneToMany(mappedBy = "customer")
    List<Offer> offerList;
}
