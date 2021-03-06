package com.twologinpages.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminDetail implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


//        Admin table
//        Admin admin = serviceJpa.findAdminByEmail(email);

        return new org.springframework.security.core.userdetails.User(
                "admin",
                passwordEncoder.encode("admin"),
                true,
                true,
                true,
                true,
                getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities(){

        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return authList;

    }



}
