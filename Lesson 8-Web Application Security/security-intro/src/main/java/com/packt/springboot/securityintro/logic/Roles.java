package com.packt.springboot.securityintro.logic;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Roles {
    USER,
    ADMIN;

    @Getter
    private SimpleGrantedAuthority authority;

    Roles() {
        this.authority = new SimpleGrantedAuthority("ROLE_" + name());
    }
}
