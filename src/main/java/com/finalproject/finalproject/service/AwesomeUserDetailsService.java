package com.finalproject.finalproject.service;

import com.finalproject.finalproject.repo.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
@AllArgsConstructor
public class AwesomeUserDetailsService implements UserDetailsService {

    @Autowired
    private final AccountRepository userRepo;

//    public AwesomeUserDetailsService(AccountRepository userRepo) {
//        this.userRepo = userRepo;
//    }

    @Override
    public AwesomeUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(username);
        var userDetails = new AwesomeUserDetails(user);
        System.out.println("when i create it" + userDetails.getAuthorities());
        return userDetails;
    }

}
