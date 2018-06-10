package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.config.GreetingProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class GreetingService {
    private GreetingProperties greetingProperties;

    public String greet(String name){
        return (name+" greets "+greetingProperties.getSuffix())
                //optional: get rid of duplicated spaces
                .replaceAll("  "," ");
    }
}
