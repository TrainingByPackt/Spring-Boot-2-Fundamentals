package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    /*
     *  You can not only reference beans or property values, you
     *  can even call methods and access properties without get/set prefixes
     */
    @Value("#{blogService.timeMessage.toUpperCase()}")
    String message;

    @Value("${my.config.feature.flag:false}")
    boolean featureFlag;

    public void save(BlogEntry entry) {
        if (entry.getTitle() == null || entry.getBody() == null) {
            throw new IllegalArgumentException("Data missing");
        }
        if (entry.getDate() == null) {
            entry.setDate(LocalDateTime.now());
        }
        blogRepository.add(entry);
    }

    @Autowired
    public void init(Environment env) {
        log.info("my.config.value={}",
                env.getProperty("my.config.value",
                        Integer.class, 42));

        log.info("SpEL message: {}", message);
    }

    public String getTimeMessage(){
        return "It is "+LocalTime.now();
    }
}
