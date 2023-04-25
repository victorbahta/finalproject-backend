package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;

import java.util.List;

public interface OfferService {

    public Offer findById(int id);

    public List<Offer> findAll();

    void save(Offer offer);

    void deleteById(int id);

    void update(int id, Offer offer);
}
