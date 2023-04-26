package com.finalproject.finalproject.service.impl;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.repo.PropertyRepo;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    public PropertyRepo propertyRepo;

    @Override
    public Property findById(int id) {
        return propertyRepo.findById(id);
    }

    @Override
    public List<Property> findAll() {
        return propertyRepo.findAll();
    }

    @Override
    public void save(Property property) {
        propertyRepo.save(property);
    }

    @Override
    public void deleteById(int id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public void update(int id, Property property) {
        propertyRepo.save(property);
    }
}
