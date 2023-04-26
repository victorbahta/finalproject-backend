package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.*;
import com.finalproject.finalproject.repo.AccountRepository;
import com.finalproject.finalproject.repo.OfferRepo;
import com.finalproject.finalproject.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PropertyRepo propertyRepo;
    @Autowired
    OfferRepo offerRepo;

    public void createAccount(Accounts account, String role) {
        Accounts a;
        account.setRole(role);
        if(role.equals("owner")) {
            a = new Owner();
        } else if (role.equals("customer")) {
            a = new Customer();
        } else {
             a = new Admin();
        }
        a.setName(account.getName());
        a.setEmail(account.getEmail());
        a.setPassword(account.getPassword());
        a.setRole(role);
        accountRepository.save(a);

    }

    public void addOwnerProperty(Long ownerId, Property p) {
        Owner o = (Owner) accountRepository.findByAccountId(ownerId).get();
        List<Property> list = o.getPropertyList();
        list.add(p);
        o.setPropertyList(list);
        p.setOwner(o);

        propertyRepo.save(p);
        accountRepository.save(o);

    }

    public List<Property> getOwnerProperties(Long id) {
        Owner o = (Owner) accountRepository.findByAccountId(id).get();
        return o.getPropertyList();
    }

    public List<Offer> getOwnerOffers(Long id) {
        return offerRepo.getAllOwnersOffer(id);
//        List<Property> propertyList = this.getOwnerProperties(id);
//     id  List<Offer> offers =  propertyList.stream().filter(property -> !property.getOfferList().isEmpty()).flatMap(p -> p.getOfferList().stream()).collect(Collectors.toList());
//        return null;
    }

    public void addCustomerOffer(Long customerId, int pid, Offer o) {
        Customer c = (Customer) accountRepository.findByAccountId(customerId).get();
        Property p = propertyRepo.findById(pid);
        o.setOwner(p.getOwner());
        o.setStatus("PENDING");
        o.setCustomer(c);
        o.setProperty(p);
        o.setSubmitDate(LocalDate.now());
        offerRepo.save(o);
    }



    public List<Accounts> getAllUsers() {
       return accountRepository.findAll();
    }
}
