package com.packt.springboot.formhandling.blogpost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * This controller demonstrates the various methods to process data from a web form:
 *
 * <ul>
 * <li>Multiple key/value pairs</li>
 * <li>Backing bean</li>
 * <li>Validated backing bean</li>
 * </ul>
 */
@Controller
@RequestMapping("/blogposts")
@Slf4j
public class BlogPostController {

    @GetMapping("new-multiple-values")
    public String renderFormViewForSeparateValues() {
        return "blogposts/form-multiple-values";
    }

    /**
     * Render the view that contains a Thymeleaf form utilizing a backing bean.
     *
     * This method also shows how the form can be initialized by providing a backing bean in the model.
     */
    @GetMapping("new-backing-bean")
    public ModelAndView renderFormViewForBackingBean() {
        CreateBlogPostCommand createBlogPostCommand = new CreateBlogPostCommand();
        createBlogPostCommand.setTitle("Default Title");

        return new ModelAndView("blogposts/form-backing-bean", "blogPostCommand", createBlogPostCommand);
    }

    /**
     * Render the view that contains a Thymeleaf form utilizing a validated backing bean.
     *
     * This method also shows how the form can be initialized by providing a backing bean in the model.
     */
    @GetMapping("new-validated-bean")
    public ModelAndView renderFormViewForValidatedBean() {
        CreateValidatedBlogPostCommand createValidatedBlogPostCommand = new CreateValidatedBlogPostCommand();
        createValidatedBlogPostCommand.setTitle("Default Title");

        return new ModelAndView("blogposts/form-validated-bean", "validatedBlogPostCommand", createValidatedBlogPostCommand);
    }

    /**
     * Create a new blog post by processing multiple key/value parameters and display the result.
     */
    @PostMapping("create-multiple-values")
    public ModelAndView createBlogPostFromMultipleValues(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "slug", required = false) String slug,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "visible", required = false) boolean visible) {
        BlogPost createdBlogPost = createBlogPost(title, slug, content, visible);

        return new ModelAndView("blogposts/show", "blogPost", createdBlogPost);
    }

    /**
     * Create a new blog post by processing separate key/value parameters and display the result.
     */
    @PostMapping("create-backing-bean")
    public ModelAndView createBlogPostFromBackingBean(@ModelAttribute CreateBlogPostCommand createBlogPostCommand) {
        BlogPost createdBlogPost = createBlogPost(
                createBlogPostCommand.getTitle(),
                createBlogPostCommand.getSlug(),
                createBlogPostCommand.getContent(),
                createBlogPostCommand.isVisible());

        return new ModelAndView("blogposts/show", "blogPost", createdBlogPost);
    }

    /**
     * Create a new blog post by processing separate key/value parameters and display the result.
     */
    @PostMapping("create-validated-bean")
    public String createBlogPostFromValidatedBean(
            @Valid @ModelAttribute CreateValidatedBlogPostCommand createValidatedBlogPostCommand,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "blogposts/form-validated-bean";
        }

        BlogPost createdBlogPost = createBlogPost(
                createValidatedBlogPostCommand.getTitle(),
                createValidatedBlogPostCommand.getSlug(),
                createValidatedBlogPostCommand.getContent(),
                createValidatedBlogPostCommand.isVisible());

        model.addAttribute("blogPost", createdBlogPost);
        return "blogposts/show";
    }

    /**
     * Simulate some processing being done to create a given blog post.
     */
    private BlogPost createBlogPost(String title, String slug, String content, boolean visible) {
        BlogPost createdBlogPost = new BlogPost(
                LocalDateTime.now(),
                title,
                slug,
                content,
                visible);

        log.info("Created blog post {}", createdBlogPost);

        return createdBlogPost;
    }

}
