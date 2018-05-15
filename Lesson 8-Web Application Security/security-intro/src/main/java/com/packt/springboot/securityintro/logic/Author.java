package com.packt.springboot.securityintro.logic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;

@Data
@Builder
@AllArgsConstructor
public class Author implements UserDetails {
    private String username;

    private String fullName;

    private String password;

    private boolean admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return admin
                ? asList(Roles.ADMIN.getAuthority(), Roles.USER.getAuthority())
                : singleton(Roles.USER.getAuthority());
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
}
