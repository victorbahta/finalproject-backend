package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Integer> {
    List<Property> findAll();

    Property findById(int id);

}
