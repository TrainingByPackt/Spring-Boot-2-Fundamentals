package com.packt.springboot.restintro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle the ‘Message Of The Day’ (or motd).
 * Uses a proper PUT/GET pair, and a proper HTTP status code.
 *
 * @author Michael Piefel
 */
@RestController
@RequestMapping(path = "/api/motd")
public class MotdController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Message {
        private String message;
    }

    private String motd = "";

    @GetMapping
    public Message retrieveMotd() {
        return new Message(motd);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void storeMotd(@RequestBody Message message) {
        motd = message.getMessage();
    }

}
