package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.dto.CustomUserDetails;
import com.exercises.spring.springproject04.entities.LoginEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private LoginServiceDao loginService;

    public CustomUserDetailsService() {
    }

    @Autowired
    public CustomUserDetailsService(LoginServiceDao loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoggerFactory.getLogger(CustomUserDetailsService.class).debug("AUTORYZACJA");
        return getDbUser(s);
//        return getTestNonUser();
    }

    public UserDetails getDbUser(String username){
        LoginEntity loginEntity = loginService.findLoginByUsername(username);
        CustomUserDetails user = null;
        if (loginEntity != null) {
            user = new CustomUserDetails(loginEntity, getTmpAuthority());
        }
        return user;
    }

    public UserDetails getTestUser(){
        String username = "admin";
        String password = "admin";

        User user = new User(username, password, getTmpAuthority());
        return user;
    }

    public UserDetails getTestNonUser(){
        return null;
    }


    public Collection<GrantedAuthority> getTmpAuthority(){
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        return Arrays.asList(authority);
    }

}
