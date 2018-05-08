package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositorySpringIntegrationTest {

    @Autowired
    List<BlogEntry> db;

    @Autowired
    BlogRepository repository;

    @Test
    public void testAdd() {
        BlogEntry entry = new BlogEntry();
        repository.add(entry);
        assertThat(db).contains(entry);
    }
}