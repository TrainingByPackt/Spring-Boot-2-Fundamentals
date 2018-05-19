package com.packt.springboot.securityintro.logic;

import com.packt.springboot.securityintro.logic.OverAnnotatedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OverAnnotatedServiceTest {

    @Autowired
    private OverAnnotatedService overAnnotatedService;

    @Test
    @WithMockUser
    public void getMessageWithMockUserCustomAuthorities() {
        overAnnotatedService.sec1a();
    }

    @Test
    @WithAnonymousUser
    public void getMessage() {
        try {
            overAnnotatedService.sec1a();
            fail();
        } catch (AccessDeniedException e) {
            // succeed
        }
    }
}