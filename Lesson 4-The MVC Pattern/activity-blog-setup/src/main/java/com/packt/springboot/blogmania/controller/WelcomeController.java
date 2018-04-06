package com.packt.springboot.blogmania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String renderWelcome() {
        return "welcome";
    }
}
