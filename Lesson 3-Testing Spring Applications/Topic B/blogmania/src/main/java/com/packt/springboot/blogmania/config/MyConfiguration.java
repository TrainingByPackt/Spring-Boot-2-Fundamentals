package com.packt.springboot.blogmania.config;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableConfigurationProperties({MyProperties.class})
public class MyConfiguration {

    /**
     * Every Bean that has a dependency on "theDate" will get the
     * single instance containing the timestamp of the spring context
     * startup
     */
    @Bean
    public Date theDate(){
        return new Date();
    }

    /**
     * Every Bean that has a dependency on "myDate" will get its own
     * instance containing the timestamp of its instantiation
     */
    @Bean @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Date myDate(){
        return new Date();
    }

    /**
     * Every Bean that has a dependency on "theLazyDate" will get this one
     * instance. The timestamp will be the time of the first method access
     * on the instance.
     */
    @Bean @Lazy
    public Date theLazyDate(){
        return new Date();
    }

    @Bean
    public List<BlogEntry> inMemoryDb(){
        return new ArrayList<>();
    }
}
