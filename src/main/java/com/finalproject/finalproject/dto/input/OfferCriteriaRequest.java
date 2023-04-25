package com.finalproject.finalproject.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferCriteriaRequest {

    String property;

    Date startDate;

    Date endDate;

    String location;
}
