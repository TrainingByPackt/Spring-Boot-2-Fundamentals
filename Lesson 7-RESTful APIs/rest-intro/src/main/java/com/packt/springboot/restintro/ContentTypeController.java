package com.packt.springboot.restintro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Spring REST controller to demonstrate how produce and consume
 * different media types (or MIME types, or Content-Type in HTTP).
 *
 * @author Michael Piefel
 */
@RestController
@RequestMapping(path = "/api/greeting")
public class ContentTypeController {

    @Data
    @AllArgsConstructor
    private static class SimpleMessage {
        private String message;
    }

    /**
     * GET a greeting as text/plain content-type
     */
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String greetText() {
        return "Hello with plain text";
    }

    /**
     * GET a greeting as application/json content-type
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleMessage greetJson() {
        return new SimpleMessage("Hello with JSON");
    }

    @Data
    @NoArgsConstructor // Jackson needs this
    @AllArgsConstructor // We need this
    private static class SpecificMessage {
        private String addressee;
        private String message;
    }

    /**
     * POST with URL parameter (and get a greeting back)
     */
    @PostMapping
    public SpecificMessage greetFromPath(@RequestParam String addressee) {
        return new SpecificMessage(addressee, "Hello " + addressee);
    }

    /**
     * POST a form parameter (and get a greeting back)
     */
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SpecificMessage greetFromText(@RequestParam String addressee) {
        return new SpecificMessage(addressee, "Hello " + addressee);
    }

    /**
     * POST a JSON record (and get a greeting back)
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpecificMessage greetFromJson(@RequestBody SpecificMessage input) {
        return new SpecificMessage(input.addressee, "Re: " + input.message);
    }

}
