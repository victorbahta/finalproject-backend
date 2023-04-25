package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.domain.Admin;
import com.finalproject.finalproject.domain.Customer;
import com.finalproject.finalproject.domain.Owner;
import com.finalproject.finalproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Accounts account, String role) {
        Accounts a;
        a = (Admin) account;
        if(role.equals("owner")) {
            a = (Owner) account;
        } else if (role.equals("customer")) {
            a = (Customer) account;
        }
        accountRepository.save(a);
    }
}
