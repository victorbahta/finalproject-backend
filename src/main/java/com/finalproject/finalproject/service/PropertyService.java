package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Property;

import java.util.List;

public interface PropertyService {

    public Property findById(int id);

    public List<Property> findAll();

    void save(Property property);

    void deleteById(int id);

    void update(int id, Property property);
}
