package com.finalproject.finalproject.service;

import com.finalproject.finalproject.controller.AccountsController;
import com.finalproject.finalproject.domain.*;
import com.finalproject.finalproject.repo.AccountRepository;
import com.finalproject.finalproject.repo.RoleReop;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    @Autowired
    private RoleReop roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Accounts account, String role) {



        Role roleObj = new Role(role);
        roleRepo.save(roleObj);
        List<Role> roles = new ArrayList<>();
        roles.add(roleObj);



        if(role.equals("owner")) {
            System.out.println("owner working");
            Owner o = new Owner();
            o.setName(account.getName());
            o.setEmail(account.getEmail());
            o.setPassword(passwordEncoder.encode(account.getPassword()));
            o.setRoles(roles);
            o.setAccountId(12);
            accountRepository.save(o);
        } else if (role.equals("customer")) {

            System.out.println("customer working");
            Customer o = new Customer();
            o.setName(account.getName());
            o.setEmail(account.getEmail());
            o.setPassword(passwordEncoder.encode(account.getPassword()));
            o.setRoles(roles);
            o.setAccountId(13);
            accountRepository.save(o);
        } else {
            Admin o = new Admin();
            o.setName(account.getName());
            o.setEmail(account.getEmail());
            o.setPassword(passwordEncoder.encode(account.getPassword()));
            o.setRoles(roles);
            o.setAccountId(13);
            accountRepository.save(o);
        }

    }

    public List<Accounts> getAllUsers() {
       return accountRepository.findAll();
    }

    public Accounts getUSetByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
