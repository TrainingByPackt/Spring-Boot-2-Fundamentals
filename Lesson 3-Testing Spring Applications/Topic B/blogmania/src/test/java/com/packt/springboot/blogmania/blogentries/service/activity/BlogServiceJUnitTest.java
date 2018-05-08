package com.packt.springboot.blogmania.blogentries.service.activity;

import com.packt.springboot.blogmania.blogentries.model.BlogEntry;
import com.packt.springboot.blogmania.blogentries.service.BlogRepository;
import com.packt.springboot.blogmania.blogentries.service.BlogService;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static com.packt.springboot.blogmania.blogentries.service.activity.BlogServiceSpringIntegrationMockTest.generateBlogEntries;
import static org.assertj.core.api.Assertions.assertThat;

public class BlogServiceJUnitTest {

    @Test
    public void retrievePagedBlogEntriesSuccess() {
        List<BlogEntry> expected = generateBlogEntries(5);
        BlogService blogService = new BlogService(new BRStub(expected));

        List<BlogEntry> entries = blogService.retrievePagedBlogEntries(0, 5);

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
    //To test the service in isolation, we have to provide our own Repository implementation
    private static class BRStub extends BlogRepository {
        final List<BlogEntry> db;

        BRStub(List<BlogEntry> db) {
            //We have no interface, so we have to extend the old class
            super(null);
            this.db = db;
        }

        @Override
        public void add(BlogEntry entry) {
            throw new NotImplementedException();
        }

        @Override
        public List<BlogEntry> retrieveBlogEntries() {
            return db;
        }
    }
}
