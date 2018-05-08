package com.packt.springboot.blogmania.blogentries.service.activity;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import com.packt.springboot.blogmania.blogentries.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static com.packt.springboot.blogmania.blogentries.service.activity.BlogServiceSpringIntegrationMockTest.generateBlogEntries;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceSpringIntegrationTest {
    @Autowired
    List<BlogEntry> db;
    @Autowired
    BlogService blogService;

    @Test
    public void retrievePagedBlogEntriesSuccess() {
        db.clear();
        db.addAll(generateBlogEntries(5));

        List<BlogEntry> entries = blogService.retrievePagedBlogEntries(0, 5);

        assertThat(entries).hasSize(5);
        assertThat(entries).containsAll(db);
    }

    @Test(expected = ConstraintViolationException.class)
    public void retrievePagedBlogEntriesFailsWithPageSize0() {
        db.clear();
        db.addAll(generateBlogEntries(5));

        blogService.retrievePagedBlogEntries(0, 0);
        fail("Exception should be thrown");
    }

    @Test(expected = ConstraintViolationException.class)
    public void retrievePagedBlogEntriesFailsWithPageLessThan0() {
        db.clear();
        db.addAll(generateBlogEntries(5));

        blogService.retrievePagedBlogEntries(-1, 5);
        fail("Exception should be thrown");
    }
}
