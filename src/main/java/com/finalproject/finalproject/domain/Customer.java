package com.finalproject.finalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer extends Accounts {

    @OneToMany(mappedBy = "customer")
    List<Offer> offerList;
}
