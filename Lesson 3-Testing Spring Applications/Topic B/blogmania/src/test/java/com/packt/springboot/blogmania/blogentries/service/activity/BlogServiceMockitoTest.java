package com.packt.springboot.blogmania.blogentries.service.activity;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import com.packt.springboot.blogmania.blogentries.service.BlogRepository;
import com.packt.springboot.blogmania.blogentries.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.packt.springboot.blogmania.blogentries.service.activity.BlogServiceSpringIntegrationMockTest.generateBlogEntries;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceMockitoTest {
    @Mock
    BlogRepository blogRepository;
    @InjectMocks
    BlogService blogService;

    @Test
    public void retrievePagedBlogEntriesSuccess() {
        List<BlogEntry> expected = generateBlogEntries(5);
        when(blogRepository.retrieveBlogEntries()).thenReturn(expected);

        List<BlogEntry> entries = blogService.retrievePagedBlogEntries(0, 5);

        verify(blogRepository).retrieveBlogEntries();
        assertThat(entries).hasSize(5);
        assertThat(entries).containsAll(expected);
    }

    /*
        Cannot be tested, because we can't enable Bean validation
        @Test(expected = ConstraintViolationException.class)
        public void retrievePagedBlogEntriesFailsWithPageSize0() {
            List<BlogEntry> expected = generateBlogEntries(5);
            BlogService blogService = new BlogService(new BRStub(expected));

            blogService.retrievePagedBlogEntries(0, 0);
            fail("Exception should be thrown");
        }


        @Test(expected = ConstraintViolationException.class)
        public void retrievePagedBlogEntriesFailsWithPageLessThan0() {
            List<BlogEntry> expected = generateBlogEntries(5);
            BlogService blogService = new BlogService(new BRStub(expected));

            blogService.retrievePagedBlogEntries(-1, 5);
            fail("Exception should be thrown");
        }
    */
}
