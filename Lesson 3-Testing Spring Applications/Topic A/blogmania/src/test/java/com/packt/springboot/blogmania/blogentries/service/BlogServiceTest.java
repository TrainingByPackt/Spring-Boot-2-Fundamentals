package com.packt.springboot.blogmania.blogentries.service;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTest {
    @Mock
    BlogRepository blogRepository;

    @InjectMocks
    BlogService blogService;

    @Test
    public void save() {
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Spring Boot 2 rocks!");
        entry.setBody("Create java webservices in a breeze");
        blogService.save(entry);
        //You can for example verify that an entry is saved to the repository
        verify(blogRepository).add(entry);
    }

    @Test
    public void init() {
        Environment env = mock(Environment.class);

        blogService.init(env);
        //You can also check that certain environment variables are fetched from the provided instance
        verify(env).getProperty(eq("my.config.value"),
                eq(Integer.class), anyInt());
    }

    @Test
    public void getTimeMessage() {
        //Of course sometimes you just verify basic invariants
        assertThat(blogService.getTimeMessage()).startsWith("It is");
        //You could also introduce the Clock dependency and use that to provide a fixed point in
        //time, then you can write a better test, but this is out of scope for now
    }
}