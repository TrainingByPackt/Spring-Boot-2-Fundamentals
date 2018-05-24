package com.packt.springboot.securityintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final ShortMessageService sms;

    @GetMapping("/")
    public String homePage(Model model) {
        // Fill in the messages for the model
        List<ShortMessage> shortMessages = sms.findAll();
        model.addAttribute("shortMessages", shortMessages);
        return "index";
    }

    @GetMapping("/api/messages.json")
    @ResponseBody
    public List<ShortMessage> retrieveShortMessages() {
        return sms.findAll();
    }

}
