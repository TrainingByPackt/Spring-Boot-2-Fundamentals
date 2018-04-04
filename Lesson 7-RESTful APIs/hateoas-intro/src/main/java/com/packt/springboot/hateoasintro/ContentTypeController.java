package com.packt.springboot.hateoasintro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller to demonstrate how produce and consume
 * different media types (or MIME types, or Content-Type in HTTP).
 *
 * @author Michael Piefel
 */
@RestController
@RequestMapping(path = "/api/greeting")
public class ContentTypeController {

    @Getter
    @AllArgsConstructor
    private static class Message {
        private String addressee;
        private String message;
    }

    /**
     * GET with URL parameter (and get a greeting back)
     */
    @GetMapping
    public Message greetFromPath(@RequestParam String addressee) {
        return new Message(addressee, "Hello " + addressee);
    }

}
