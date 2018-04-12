package com.packt.springboot.blogmania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class TestBase {
    @Autowired
    ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
