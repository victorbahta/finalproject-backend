package com.finalproject.finalproject.service;

import com.finalproject.finalproject.dto.input.LoginRequest;
import com.finalproject.finalproject.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
//    private PasswordEncoder passwordEncoder;
//    private final UserDetailsService userDetailsService;
    private final AwesomeUserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    public String login(LoginRequest loginRequest) {
        Authentication result = null;

        try{
            System.out.println("inside the function try");
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            System.out.println("after the function try");
        }catch(BadCredentialsException e){
            throw  new BadCredentialsException(e.getMessage());
        }
        final AwesomeUserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        final String accessToken = jwtUtil.generateToken(userDetails);
        //refresh token
//        var loginResponce = new LoginResponce(accessToken);
        return accessToken;
    }
}
