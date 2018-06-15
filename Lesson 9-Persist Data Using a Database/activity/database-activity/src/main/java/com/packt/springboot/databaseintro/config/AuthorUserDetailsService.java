package com.packt.springboot.databaseintro.config;

import com.packt.springboot.databaseintro.logic.Author;
import com.packt.springboot.databaseintro.logic.AuthorService;
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
        Optional<Author> author = authorService.lookupByName(username);
        if (!author.isPresent()) {
            String message = "No user known for " + username;
            log.info(message);
            throw new UsernameNotFoundException(message);
        }
        log.info("Authenticating {} with {}", username, author.get().getAuthorities());
        return author.get();
    }

}
