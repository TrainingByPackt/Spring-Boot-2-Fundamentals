package com.packt.springboot.blogmania;

import com.packt.springboot.blogmania.config.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestClass extends TestBase  {

    @Autowired
    MyConfiguration myConfig2;

    @PostConstruct
    public void post(){
        System.out.println(myConfig2);
        System.out.println(myConfig);
    }
}
