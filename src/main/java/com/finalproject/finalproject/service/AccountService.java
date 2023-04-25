package com.finalproject.finalproject.service;

import com.finalproject.finalproject.controller.AccountsController;
import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.domain.Admin;
import com.finalproject.finalproject.domain.Customer;
import com.finalproject.finalproject.domain.Owner;
import com.finalproject.finalproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Accounts account, String role) {

        if(role.equals("owner")) {
            Owner o = new Owner();
            o.setName(account.getName());
            o.setEmail(account.getEmail());
            o.setPassword(account.getPassword());
            accountRepository.save(o);
        } else if (role.equals("customer")) {;
            Customer c = new Customer();
            c.setName(account.getName());
            c.setEmail(account.getEmail());
            c.setPassword(account.getPassword());
            accountRepository.save(c);
        } else {
            Admin a = (Admin) account;
            accountRepository.save(a);
        }

    }

    public List<Accounts> getAllUsers() {
       return accountRepository.findAll();
    }
}
