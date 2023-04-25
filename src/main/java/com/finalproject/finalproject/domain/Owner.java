package com.finalproject.finalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Owner extends Accounts {

    @OneToMany(mappedBy = "owner")
    List<Property> propertyList;
}
