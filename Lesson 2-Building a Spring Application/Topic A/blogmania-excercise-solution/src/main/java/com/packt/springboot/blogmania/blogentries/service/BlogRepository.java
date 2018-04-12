package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepository {
    @Autowired
    List<BlogEntry> db;

    public void add(BlogEntry entry){
        db.add(entry);
    }
}
