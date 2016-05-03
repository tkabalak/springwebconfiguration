package com.exercises.spring.springproject04.dto;

import com.exercises.spring.springproject04.entities.LoginEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final LoginEntity login;
    private final Collection<GrantedAuthority> authorities;
//    private final boolean accountNonExpired;
//    private final boolean accountNonLocked;
//    private final boolean credentialsNonExpired;
//    private final boolean enabled;

    public CustomUserDetails(LoginEntity login, Collection<GrantedAuthority> authorities) {
        this.login = login;
        this.authorities = authorities;

        //boolean a = login.getActiveUser() == (long) 1;
    }

    @Override
    public String getUsername() {
        return login.getUsername();
    }

    @Override
    public String getPassword() {
        return login.getPassword();
    }

    public LoginEntity getLogin(){
        return login;
    }

    public Long getId(){
        return login.getEmployeeId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return new ArrayList<GrantedAuthority>(){{add(new SimpleGrantedAuthority("ROLE_ADMIN"));}};
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "login=" + login.toString() +
                '}';
    }
}
