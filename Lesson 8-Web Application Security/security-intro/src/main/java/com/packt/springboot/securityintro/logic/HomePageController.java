package com.packt.springboot.securityintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.Authentication;
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
    private final OverAnnotatedService overAnnotatedService;
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
        callAllAnnotatedMethods(); // TODO Somewhere else?

        val authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("authorities", authentication.getAuthorities());
        log.info("auth {}", authentication.getAuthorities());

        Object principal = authentication.getPrincipal();
        String username = principal instanceof UserDetails
                ? ((UserDetails) principal).getUsername()
                : principal.toString();
        model.addAttribute("username", username);
        log.info("prin {}  ;  usr {}", principal.getClass(), username);

        List<ShortMessage> shortMessages = sms.findAll();
        model.addAttribute("shortMessages", shortMessages);
        return "index";
    }

    private void callAllAnnotatedMethods() {
        log.error("");
        log.error("---------------------------------------------------------");
        try {
            log.info(overAnnotatedService.sec1a());
        } catch (RuntimeException e) {
            log.warn("{} on sec1a", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec1b());
        } catch (RuntimeException e) {
            log.warn("{} on sec1b", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec2a());
        } catch (RuntimeException e) {
            log.warn("{} on sec2a", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec2b());
        } catch (RuntimeException e) {
            log.warn("{} on sec2b", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec3a());
        } catch (RuntimeException e) {
            log.warn("{} on sec3a", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec3b());
        } catch (RuntimeException e) {
            log.warn("{} on sec3b", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec3c());
        } catch (RuntimeException e) {
            log.warn("{} on sec3c", e.getMessage());
        }
        try {
            log.info(overAnnotatedService.sec3d());
        } catch (RuntimeException e) {
            log.warn("{} on sec3d", e.getMessage());
        }
        log.error("---------------------------------------------------------");
        log.error("");
    }

}
