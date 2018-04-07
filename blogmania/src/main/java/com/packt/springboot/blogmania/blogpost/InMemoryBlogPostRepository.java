package com.packt.springboot.blogmania.blogpost;

import com.packt.springboot.blogmania.author.Author;
import com.packt.springboot.blogmania.category.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBlogPostRepository implements BlogPostRepository {
    private List<BlogPost> blogPosts;

    @PostConstruct
    public void init() {
        blogPosts = new ArrayList<>();

        BlogPost post1 = new BlogPost(
                LocalDateTime.of(2018, Month.APRIL, 7, 12, 23, 42),
                new Author("Toni", "Tester", "toni@tester.de"),
                new Category("general", "General"),
                true,
                PublicationState.PUBLISHED,
                "first-blog-post",
                "First Blog Post",
                "This is a first Blog Post",
                "<p>This is the <strong>first</strong> Blog Post that should appear in BlogMania.</p>"
        );

        BlogPost post2 = new BlogPost(
                LocalDateTime.of(2018, Month.APRIL, 9, 13, 21, 8),
                new Author("Toni", "Tester", "toni@tester.de"),
                new Category("general", "General"),
                true,
                PublicationState.PUBLISHED,
                "second-blog-post",
                "Second Blog Post",
                "This is a second Blog Post",
                "<p>This is the <em>second</em> Blog Post that should appear in BlogMania.</p>"
        );

        blogPosts.add(post1);
        blogPosts.add(post2);
    }

    @Override
    public List<BlogPost> findAll() {
        return new ArrayList<>(blogPosts);
    }
}
