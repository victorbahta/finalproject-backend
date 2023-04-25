package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AccountsController {
    @Autowired
    AccountService accountService;
    @PostMapping("/signup")
    public void createAccount(@RequestBody Accounts account, @RequestParam(name = "role", required = false) String role) {
        accountService.createAccount(account, role);
    }
    @GetMapping()
    public List<Accounts> findAllUsers() {
        return accountService.getAllUsers();
    }
}
