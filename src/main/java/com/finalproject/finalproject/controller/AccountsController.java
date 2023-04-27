package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.domain.Message;
import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AccountsController {
    @Autowired
    AccountService accountService;
    @PostMapping()
    public void createAccount(@RequestBody Accounts account, @RequestParam(name = "role", required = false) String role) {
        accountService.createAccount(account, role);
    }
    @PostMapping("/multiple")
    public void createAccount(@RequestBody List<Accounts> accounts, @RequestParam(name = "role", required = false) String role) {
        for (Accounts a: accounts) {
            this.createAccount(a, role);

        }
    }


    @GetMapping("/recent")
    public List<Accounts> getRecentAccounts() {
        return accountService.getRecentAccounts();
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAccount(@PathVariable("id") Long id) {
        return accountService.deleteAccount(id);
    }
    @PutMapping("/{id}/deactivate")
    @ResponseBody
    public String deactivateAccount(@PathVariable("id") Long id) {
        return accountService.deactivateAccount(id);
    }
    @PutMapping("/{id}/activate")
    @ResponseBody
    public String activateAccount(@PathVariable("id") Long id) {
        return accountService.activateAccount(id);
    }
    @PutMapping("/{id}/resetpassword")
    @ResponseBody
    public String resetPassword(@PathVariable("id") Long id, Accounts a) {
        return accountService.resetPassword(id, a);
    }
    // add owner property
    @PutMapping("/{id}/property")
    public Property addOwnerProperty(@PathVariable("id") Long id, @RequestBody Property p) {
        return accountService.addOwnerProperty(id,p);
    }
    @PutMapping("/{id}/property/multiple")
    public void addMultipleOwnerProperty(@PathVariable("id") Long id, @RequestBody List<Property> properties) {
        for (Property p: properties) {
            this.addOwnerProperty(id,p);
        }
    }
    // offer from customer
    @PutMapping("/{id}/property/{pid}/offer")
    public void addCustomerOffer(@PathVariable("id") Long id, @PathVariable("pid") int pid, @RequestBody Offer o) {
        accountService.addCustomerOffer(id,pid,o);
    }
    @PutMapping("/{id}/offers/{oid}")
    public void updateOfferStatus(@PathVariable("id") Long id, @RequestBody Offer o, @PathVariable("oid") int oid) {
        accountService.updateOfferStatus(id,o, oid);
    }
    @GetMapping("/{id}/messages")
    public List<Message> getOwnerMessages(@PathVariable("id") long id) {
        return accountService.getMessages(id);
    }
    @GetMapping("/{id}/property")
    public List<Property> getOwnerProperties(@PathVariable("id") Long id) {
        return accountService.getOwnerProperties(id);
    }

    @GetMapping("/{id}/offers")
    public List<Offer> getOwnerOffers(@PathVariable("id") Long id) {
        return accountService.getOwnerOffers(id);
    }

    @GetMapping("/{id}")
    public Accounts getUser(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping()
    public List<Accounts> findAllUsers() {
        return accountService.getAllUsers();
    }


    @GetMapping("/first10")
    public List<Accounts> findFirst10ByCreatedDate(LocalDate date, Pageable pageable) {
        return accountService.findFirst10ByCreatedDate(date, pageable);
    }
    @GetMapping("/email/{email}")
    public Accounts findUserByEmail( @PathVariable("email") String email) {
        System.out.println("TRYING TO FETCH EAMIL:" + email);
        return accountService.getUSetByEmail(email);
    }
}
