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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private LoginServiceDao loginService;

    private final Map<Integer, GrantedAuthority> authorityMap = getAuthorityMap();

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
//        return getTestUser();
    }

    public UserDetails getDbUser(String username){
        LoginEntity loginEntity = loginService.findLoginByUsername(username);
        CustomUserDetails user = null;
        if (loginEntity != null) {
            Integer[] appRole = loginEntity.getAppRole();
            user = new CustomUserDetails(loginEntity, getAuthority(loginEntity));
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

    public Collection<GrantedAuthority> getAuthority(LoginEntity login) {
        return Stream.of(login.getAppRole())
                .map(e -> authorityMap.get(e))
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static Map<Integer, GrantedAuthority> getAuthorityMap() {
        // :TODO change to guava map builder
        HashMap<Integer, GrantedAuthority> authorityMap = new HashMap<>();
        authorityMap.put(0, new SimpleGrantedAuthority("ROLE_USER"));
        authorityMap.put(1, new SimpleGrantedAuthority("ROLE_MANAGER"));
        authorityMap.put(2, new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorityMap.put(3, new SimpleGrantedAuthority("ROLE_DBA"));
        return authorityMap;
    }



}
