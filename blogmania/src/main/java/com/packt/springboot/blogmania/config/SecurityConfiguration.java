package com.packt.springboot.blogmania.config;

import com.packt.springboot.blogmania.author.Author;
import com.packt.springboot.blogmania.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final AuthorRepository authorRepository;

    @Bean
    public Author loggedInAuthor() {
        return authorRepository.findById(1L).orElseThrow(() -> new IllegalStateException("Author with id 1 not found"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/webjars/**", "/login").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .httpBasic().realmName("blogmania")
        ;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));
    }
}
