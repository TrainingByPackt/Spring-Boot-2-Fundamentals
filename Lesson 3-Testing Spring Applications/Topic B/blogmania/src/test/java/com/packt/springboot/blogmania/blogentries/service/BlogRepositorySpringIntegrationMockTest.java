package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositorySpringIntegrationMockTest {

    @MockBean
    List<BlogEntry> db;

    @Autowired
    BlogRepository repository;

    @Test
    public void testAdd() {
        BlogEntry entry = new BlogEntry();
        repository.add(entry);
        Mockito.verify(db).add(eq(entry));
    }
}