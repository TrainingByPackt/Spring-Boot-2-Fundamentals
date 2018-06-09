package com.packt.springboot.blogmania.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("greeting")
public class GreetingProperties {
    String suffix="greets the developer community";
}
