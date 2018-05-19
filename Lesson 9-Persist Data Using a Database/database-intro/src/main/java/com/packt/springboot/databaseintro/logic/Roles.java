package com.packt.springboot.databaseintro.logic;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Enumeration for all roles to centralized them and use them consistently.
 * Spring does not required such a thing!
 */
public enum Roles {
    USER,
    ADMIN;

    @Getter
    private SimpleGrantedAuthority authority;

    Roles() {
        this.authority = new SimpleGrantedAuthority("ROLE_" + name());
    }
}
