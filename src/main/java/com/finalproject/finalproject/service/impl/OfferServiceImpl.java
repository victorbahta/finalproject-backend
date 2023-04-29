package com.finalproject.finalproject.service.impl;

import com.finalproject.finalproject.domain.Customer;
import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Owner;
import com.finalproject.finalproject.repo.AccountRepository;
import com.finalproject.finalproject.repo.OfferRepo;
import com.finalproject.finalproject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    AccountRepository customerRepo;
    @Autowired
    OfferRepo offerRepo;
    @Override
    public Offer findById(int id) {
        return offerRepo.findById(id);
    }

    @Override
    public List<Offer> findAll() {
        return offerRepo.findAll();
    }

    @Override
    public void save(Offer offer) {
        offerRepo.save(offer);
    }

    @Override
    public void deleteById(int id) {
        offerRepo.deleteById(id);
    }

    @Override
    public void update(int id, Offer offer) {
    // To do
        Offer oldOffer = offerRepo.findById(id);
        Customer customer = oldOffer.getCustomer();

        oldOffer.setAmount(offer.getAmount());
        oldOffer.setMessage(offer.getMessage());


        oldOffer.setSubmitDate(LocalDate.now());
        customer.getOfferList().add(oldOffer);


        customerRepo.save(customer);
        offerRepo.save(oldOffer);
    }
}
