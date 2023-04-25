package com.finalproject.finalproject.config;

import com.finalproject.finalproject.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig {


//    @Autowired
    private final JwtFilter jwtFilter;

//    @Autowired
    private final UserDetailsService userDetailsService;
    String[] roles = {"CLIENT","ADMIN"}; // You can make this a call from the DB


    @Bean
    public UserDetailsService userDetailsSvc() {
        return userDetailsService;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public SecurityConfig(JwtFilter jwtFilter, UserDetailsService userDetailsService) {
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable().cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/authenticate/**").permitAll()
                .requestMatchers("/api/v1/users").permitAll()
//                .requestMatchers("/api/v1/products").hasAuthority("CLIENT")
                .requestMatchers("/api/v1/posts").hasAnyAuthority(roles) // Dynamic authorities
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
