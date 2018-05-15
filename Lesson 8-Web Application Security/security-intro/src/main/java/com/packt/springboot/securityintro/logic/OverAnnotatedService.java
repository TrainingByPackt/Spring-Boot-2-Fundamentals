package com.packt.springboot.securityintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Try all the security access limiting annotations, with both role and authority.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OverAnnotatedService {

    @PreFilter("filterObject.content.length() < 240 or hasRole('ADMIN')")
    @PostFilter("filterObject.author.name == authentication.name")
    public List<ShortMessage> saveAndReturnAll(List<ShortMessage> posts) {
        return posts;
    }

    @RolesAllowed("USER")
    public String sec1a() {
        return "@RolesAllowed(\"USER\")";
    }

    @RolesAllowed("ROLE_USER")
    public String sec1b() {
        return "@RolesAllowed(\"ROLE_USER\")";
    }

    @Secured("USER")
    public String sec2a() {
        return "@Secured(\"USER\")";
    }

    @Secured("ROLE_USER")
    public String sec2b() {
        return "@Secured(\"ROLE_USER\")";
    }

    @PreAuthorize("hasRole('USER')")
    public String sec3a() {
        return "@PreAuthorize(\"hasRole('USER')\")";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public String sec3b() {
        return "@PreAuthorize(\"hasRole('ROLE_USER')\")";
    }

    @PreAuthorize("hasAuthority('USER')")
    public String sec3c() {
        return "@PreAuthorize(\"hasAuthority('USER')\")";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String sec3d() {
        return "@PreAuthorize(\"hasAuthority('ROLE_USER')\")";
    }
}
