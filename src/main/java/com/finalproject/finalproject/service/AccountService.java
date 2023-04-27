package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.*;
import com.finalproject.finalproject.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Autowired
    private RoleReop roleRepo;
    @Autowired
    private MessageService msgService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Accounts> getRecentAccounts() {
        List<Accounts> recentAccounts = accountRepository.findAll();

        return recentAccounts.stream().filter(a -> !(a instanceof Admin)).limit(10).collect(Collectors.toList());
    }
    public void createAccount(Accounts account, String role) {
        Role roleObj = new Role(role);
        roleRepo.save(roleObj);
        List<Role> roles = new ArrayList<>();
        roles.add(roleObj);

        Accounts a;
        if(role.equals("owner")) {
            a = new Owner();
        } else if (role.equals("customer")) {
            a = new Customer();
        } else {
             a = new Admin();
        }
        a.setName(account.getName());
        a.setEmail(account.getEmail());
        a.setPassword(passwordEncoder.encode(account.getPassword()));
        a.setRoles(roles);
        a.setCreatedDate(LocalDate.now());
        a.setStatus("inactive");
        accountRepository.save(a);

    }


@Transactional
    public String deleteAccount(Long id) {
        accountRepository.deleteAccountsByAccountId(id);
        return "Account deleted";
    }

    public String deactivateAccount(Long id) {
        Accounts a = accountRepository.findByAccountId(id).get();
        a.setStatus("inactive");
        accountRepository.save(a);
        return "Account deactivated";
    }
    public String activateAccount(Long id) {
        Accounts a = accountRepository.findByAccountId(id).get();
        a.setStatus("active");
        accountRepository.save(a);
        return "Account activated";
    }
    public String resetPassword(Long id, Accounts password) {
        Accounts a = accountRepository.findByAccountId(id).get();
        a.setPassword(password.getPassword());
        accountRepository.save(a);
        return "Password is reset";
    }

    public Property addOwnerProperty(Long ownerId, Property p) {
        Owner o = (Owner) accountRepository.findByAccountId(ownerId).get();
        List<Property> list = o.getPropertyList();
        list.add(p);
        o.setPropertyList(list);
        p.setOwner(o);

        accountRepository.save(o);
        Property property = propertyRepo.save(p);
        return property;


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
        Owner owner = p.getOwner();
        Message msg = new Message();
        String offer_msg = o.getMessage().isEmpty() ? "Customer "+ c.getName()+" sent you an offer" : o.getMessage();
        msg.setMsg(offer_msg);
        msg.setCustomer(c);
        msg.setOwner(owner);
        msg.setProperty(p);
        msgService.saveMsg(msg);
        o.setOwner(owner);
        o.setStatus("PENDING");
        o.setCustomer(c);
        o.setProperty(p);
        o.setSubmitDate(LocalDate.now());
        offerRepo.save(o);

    }

    public List<Message> getMessages(long id) {
       return  msgService.getAllMsgs(id);
    }
    public void updateOfferStatus(Long ownerId, Offer o, int oid) {
        List<Offer> offers = offerRepo.getAllOwnersOffer(ownerId);
        Offer offer = offers.stream().filter(of->of.getId() == oid).findFirst().get();
        offer.setStatus(o.getStatus());
        offerRepo.save(offer);
    }

public Accounts getAccountById(long id){
    return accountRepository.findByAccountId(id).get();

}

    public List<Accounts> getAllUsers() {
       return accountRepository.findAll();
    }


    public List<Accounts> findFirst10ByCreatedDate(LocalDate date, Pageable pageable){
        return accountRepository.findFirst10ByCreatedDate(date, pageable);
    }


    public Accounts getUSetByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

}
