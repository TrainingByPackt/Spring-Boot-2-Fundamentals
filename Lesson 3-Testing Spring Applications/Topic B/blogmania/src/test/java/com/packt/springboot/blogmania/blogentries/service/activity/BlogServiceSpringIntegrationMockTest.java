package com.packt.springboot.blogmania.blogentries.service.activity;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import com.packt.springboot.blogmania.blogentries.service.BlogRepository;
import com.packt.springboot.blogmania.blogentries.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogServiceSpringIntegrationMockTest {
    @MockBean
    BlogRepository blogRepository;
    @Autowired
    BlogService blogService;

    @Test
    public void retrievePagedBlogEntriesSuccess() {
        List<BlogEntry> expected = generateBlogEntries(5);
        when(blogRepository.retrieveBlogEntries())
                .thenReturn(expected);

        List<BlogEntry> entries = blogService.retrievePagedBlogEntries(0, 5);

        assertThat(entries).hasSize(5);
        assertThat(entries).containsAll(expected);

    }

    @Test(expected = ConstraintViolationException.class)
    public void retrievePagedBlogEntriesFailsWithPageSize0() {
        List<BlogEntry> expected = generateBlogEntries(5);
        when(blogRepository.retrieveBlogEntries())
                .thenReturn(expected);

        blogService.retrievePagedBlogEntries(0, 0);
        fail("Exception should be thrown");
    }


    @Test(expected = ConstraintViolationException.class)
    public void retrievePagedBlogEntriesFailsWithPageLessThan0() {
        List<BlogEntry> expected = generateBlogEntries(5);
        when(blogRepository.retrieveBlogEntries())
                .thenReturn(expected);

        blogService.retrievePagedBlogEntries(-1, 5);
        fail("Exception should be thrown");
    }

    static List<BlogEntry> generateBlogEntries(int count) {
        ArrayList<BlogEntry> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //Create an entry with varying data
            BlogEntry entry = new BlogEntry();
            entry.setDate(LocalDateTime.now().minusDays(i));
            entry.setBody("Blog entry no. " + i);
            entry.setTitle("Entry " + i);
            entry.setVisible(i % 2 == 0);
            list.add(entry);
        }
        return list;
    }
}
