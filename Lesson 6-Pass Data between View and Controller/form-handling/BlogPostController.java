package com.packt.springboot.formhandling.blogpost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogposts")
@Slf4j
public class BlogPostController {

    /**
     * Create a new blog post by processing a key/value parameter.
     */
    @PostMapping("create")
    public void createFromRequestParam(@RequestParam String title) {
        log.info("The title is " + title);
    }

}
