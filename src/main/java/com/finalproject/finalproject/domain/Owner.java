package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Owner extends Accounts {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
            @JsonManagedReference
    List<Property> propertyList;
}
