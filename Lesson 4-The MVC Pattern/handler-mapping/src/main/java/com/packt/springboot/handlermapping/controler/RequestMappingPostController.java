package com.packt.springboot.handlermapping.controler;

import com.packt.springboot.handlermapping.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * This class demonstrates how the {@link RequestMappingHandlerMapping} picks up annotated controller.
 */

@Controller
@RequestMapping("/posts")
public class RequestMappingPostController {

    @RequestMapping(path = "/newest", method = RequestMethod.GET)
    public String showNewestPost() {
        // This method will be mapped to
        // GET requests with the path /posts/newest
        return "newest";
    }

    @GetMapping("/all")
    public String showAllPosts() {
        // This method will be mapped to
        // GET requests with the path /posts/all
        return "list";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addPost(@RequestBody Post post) {
        // This method will be mapped to
        // POST requests with the path /posts
        return "posts/editor";
    }

    @PostMapping("/posts")
    public String addPostModel(@ModelAttribute("post") Post post) {
        // post will get the model attribute named post
        return "posts/details";
    }

    @GetMapping("/form")
    public String setupForm(@RequestParam("formId") int formId) {
        // When requesting /form?formId=1
        // formId will get the value 1
        return "form";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String showWelcomeMessage() {
        return "<html><head></head><body>Hello</body></html>";
    }

    @GetMapping("/form/{id}")
    public String setupFormWithId(@PathVariable long id) {
        // When requesting /form/1
        // formId will get the value 1
        return "form";
    }

    @GetMapping("/form-cookie")
    public String setupFormWithCookie(@CookieValue("JSESSIONID") String jSessionId) {
        // jSessionId will get the value from the cookie called "JSESSIONID"
        return "form";
    }

    @GetMapping("/form-header")
    public String setupFormWithHeader(@RequestHeader("Keep-Alive") long keepAlive) {
        // keepAlive will get the value 300
        return "form";
    }
}
