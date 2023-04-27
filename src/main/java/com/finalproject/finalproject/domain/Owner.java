package com.finalproject.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Owner extends Accounts {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
            @JsonIgnore

    List<Property> propertyList;
}
