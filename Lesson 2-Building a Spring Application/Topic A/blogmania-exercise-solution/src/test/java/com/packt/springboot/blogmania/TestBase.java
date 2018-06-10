package com.packt.springboot.blogmania;

import com.packt.springboot.blogmania.config.MyConfiguration;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public abstract class TestBase {
    @Autowired
    MyConfiguration myConfig;

}
