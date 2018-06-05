package com.packt.springboot.securityintro.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
public class LowercaseUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username == null || username.trim().isEmpty() ||
                !username.toLowerCase().equals(username)) {
            log.info("Reject {}, accept only lowercase", username);
            throw new UsernameNotFoundException("Accept only lowercase");
        }

        String password = passwordEncoder.encode("password");
        log.info("Accepting {} / {}", username, password);
        return new User(username, password,
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
