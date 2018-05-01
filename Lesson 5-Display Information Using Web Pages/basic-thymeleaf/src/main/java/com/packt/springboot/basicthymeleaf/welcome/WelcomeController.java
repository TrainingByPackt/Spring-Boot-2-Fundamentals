package com.packt.springboot.basicthymeleaf.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute("welcome", "This is the welcome message.");

        return "welcome";
    }
}
