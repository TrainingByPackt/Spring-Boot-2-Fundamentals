package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class BlogRepository {
    List<BlogEntry> db;

    public void add(BlogEntry entry){
        db.add(entry);
    }

    public List<BlogEntry> retrieveBlogEntries() {
        return new ArrayList<>(db);
    }
}
