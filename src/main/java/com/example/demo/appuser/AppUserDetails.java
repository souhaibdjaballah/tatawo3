package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Slf4j
public class AppUserDetails implements UserDetails {

    private final AppUser appUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(appUser.getAppUserRole().name()));
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // TODO: implement accountNonExpired
    }

    @Override
    public boolean isAccountNonLocked() {
        return !appUser.getLocked();
//        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // TODO: implement credentialNonExpired
    }

    @Override
    public boolean isEnabled() {
        return appUser.getEnabled();
//        return true;
    }
}
