package com.finalproject.finalproject.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCriteriaRequest {

    private Integer minPrice;

    private Integer maxPrice;

    private String propertyType;

    private String listingType;

    private Integer roomNo;

    private String location;


}
