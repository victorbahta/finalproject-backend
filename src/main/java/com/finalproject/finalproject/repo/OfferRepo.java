package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {

    List<Offer> findAll();

    Offer findById(int id);
}
