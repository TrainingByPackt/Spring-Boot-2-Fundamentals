package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final ShortMessageService sms;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam Optional<String> error) {
        if (error.isPresent()) {
            log.info("Incorrect login, warning the user");
            model.addAttribute("loginError", "true");
        }
        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        // Fill in authorities for the model
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("authorities", authentication.getAuthorities());

        // Fill in username (from principal) for the model
        Object principal = authentication.getPrincipal();
        String username = principal instanceof UserDetails
                ? ((UserDetails) principal).getUsername()
                : principal.toString();
        model.addAttribute("username", username);

        // Fill in the messages for the model
        List<ShortMessage> shortMessages = sms.findAll();
        model.addAttribute("shortMessages", shortMessages);
        return "index";
    }

}
