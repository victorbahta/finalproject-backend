package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PropertyService {

    public Property findById(int id);

    public List<Property> findAll();

    void save(Property property);

    void deleteById(int id);

    void update(int id, Property property);

}
