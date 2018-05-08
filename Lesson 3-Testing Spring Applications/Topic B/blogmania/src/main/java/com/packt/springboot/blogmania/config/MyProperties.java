package com.packt.springboot.blogmania.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("blogmania")
public class MyProperties {
    String message;
    int myInt=4;//default value
    SubProperties subs = new SubProperties();

    @Data
    public static class SubProperties{
        boolean iLikePizza=true;
    }
}
