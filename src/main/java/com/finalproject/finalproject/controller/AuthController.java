package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.dto.input.LoginRequest;
import com.finalproject.finalproject.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping
    //read this ResponseEntity<?>
    public String login(@RequestBody LoginRequest loginRequest){
        System.out.println("inside logging in");
        System.out.println(loginRequest);
        String loginResponce = authService.login(loginRequest);
        return loginResponce;
    }

}