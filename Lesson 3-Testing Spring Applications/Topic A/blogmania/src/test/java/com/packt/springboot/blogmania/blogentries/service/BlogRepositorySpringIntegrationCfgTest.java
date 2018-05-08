package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {"my.property=test","spring.application.name=systemUnderTest"},
        classes = {BlogRepositorySpringIntegrationCfgTest.TestConfigClass.class}
        )
public class BlogRepositorySpringIntegrationCfgTest {

    @SpyBean
    List<BlogEntry> db;

    @Autowired
    BlogRepository repository;

    @Test
    public void testAdd() {
        BlogEntry entry = new BlogEntry();
        repository.add(entry);
        Mockito.verify(db).add(eq(entry));
    }

    @Configuration
    @ComponentScan("com.packt.springboot.blogmania.blogentries.service")
    static class TestConfigClass {
        @Bean
        public List<BlogEntry> db(){
            return new LinkedList<>();
        }
    }
}