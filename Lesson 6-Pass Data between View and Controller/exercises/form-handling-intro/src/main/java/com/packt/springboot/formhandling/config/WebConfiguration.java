package com.packt.springboot.formhandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configure the web container.
 *
 * Add a simple view to be shown when context-root is requested.
 */
@Configuration
public class WebConfiguration {
    @Bean
    public WebMvcConfigurer initializrWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("home");
                registry.addViewController("/index").setViewName("home");
                registry.addViewController("/home").setViewName("home");
                registry.addViewController("/start").setViewName("home");
                registry.addViewController("/index.html").setViewName("home");
            }
        };
    }
}