package com.packt.springboot.blogmania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestClass extends TestBase {

    @Autowired
    ApplicationContext context2;

    @PostConstruct
    public void post(){
        System.out.println(context2);
        System.out.println(context);
    }
}
