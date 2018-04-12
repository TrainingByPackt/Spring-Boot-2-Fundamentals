package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BlogService {
    private BlogRepository blogRepository;

    public void save(BlogEntry entry) {
        if (entry.getTitle() == null || entry.getBody() == null) {
            throw new IllegalArgumentException("Data missing");
        }
        if (entry.getDate() == null) {
            entry.setDate(LocalDateTime.now());
        }
        blogRepository.add(entry);
    }
}
