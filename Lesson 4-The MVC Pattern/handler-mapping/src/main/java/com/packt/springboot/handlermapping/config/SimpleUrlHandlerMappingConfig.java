package com.packt.springboot.handlermapping.config;

import com.packt.springboot.handlermapping.controler.SimpleUrlMappingPostController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SimpleUrlHandlerMappingConfig {

    @Bean
    public SimpleUrlHandlerMapping simpleMapping() {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping
                = new SimpleUrlHandlerMapping();

        Map<String, Object> urlMap = new HashMap<>();
        urlMap.put("/simplepost", simpleUrlMappingPostController());
        simpleUrlHandlerMapping.setUrlMap(urlMap);

        return simpleUrlHandlerMapping;
    }

    @Bean
    public SimpleUrlMappingPostController simpleUrlMappingPostController() {
        return new SimpleUrlMappingPostController();
    }
}
