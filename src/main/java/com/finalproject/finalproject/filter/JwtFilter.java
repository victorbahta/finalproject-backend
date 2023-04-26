package com.finalproject.finalproject.filter;


import com.finalproject.finalproject.service.AwesomeUserDetailsService;
import com.finalproject.finalproject.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

//    private final UserDetailsService userDetailsService;
    private final AwesomeUserDetailsService userDetailsService;

    public JwtFilter(JwtUtil jwtUtil, AwesomeUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            try {
                System.out.println("in try trying to fetch email");
                email = jwtUtil.getUsernameFromToken(token);
                System.out.println("fetched succes" + email);

            } catch (ExpiredJwtException e) { // TODO come back here!

            }
        }

        if (email != null && jwtUtil.validateToken(token)) {
            var userDetails = userDetailsService.loadUserByUsername(email);
            System.out.println("userDetails" + userDetails.getUsername() + userDetails.getAuthorities());

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication);
        }

        // THIS WILL BE APPLIED - Better approach
//            if (token != null && jwtUtil.validateToken(token)) {
//            Authentication auth = jwtUtil.getAuthentication(token); // TODO need to get the authentication
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }

        System.out.println("calling the fitler chain");
        filterChain.doFilter(request, response);
    }
}

