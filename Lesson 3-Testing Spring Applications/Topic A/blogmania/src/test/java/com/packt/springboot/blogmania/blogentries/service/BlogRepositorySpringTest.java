package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class BlogRepositorySpringTest {

    @Mock
    List<BlogEntry> db;

    @InjectMocks
    BlogRepository repository;

    @Test
    public void testAdd(){
        BlogEntry entry = new BlogEntry();
        repository.add(entry);

        Mockito.verify(db).add(eq(entry));
    }
}