package com.packt.springboot.securityintro.config;

import com.packt.springboot.securityintro.logic.Author;
import com.packt.springboot.securityintro.logic.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class AuthorUserDetailsService implements UserDetailsService {
    private final AuthorService authorService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Author> author = authorService.byName(username);
        if (!author.isPresent()) {
            String message = "No user known for " + username;
            log.info(message);
            throw new UsernameNotFoundException(message);
        }
        log.info("Authenticating {} with {}", username, author.get().getAuthorities());
        return author.get();
    }

}
