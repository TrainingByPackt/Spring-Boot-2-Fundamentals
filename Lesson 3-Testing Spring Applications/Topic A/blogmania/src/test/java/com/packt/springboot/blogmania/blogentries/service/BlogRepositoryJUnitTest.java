package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class BlogRepositoryJUnitTest {

    @Test
    public void testAdd(){
        ArrayList<BlogEntry> db = new ArrayList<>();
        BlogRepository repository = new BlogRepository(db);

        BlogEntry entry = new BlogEntry();
        repository.add(entry);

        assertThat(db).contains(entry);
    }
}