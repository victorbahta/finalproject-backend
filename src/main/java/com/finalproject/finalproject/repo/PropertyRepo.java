package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {
    List<Property> findAll();

    Property save(Property p);

    Property findById(int id);



}
