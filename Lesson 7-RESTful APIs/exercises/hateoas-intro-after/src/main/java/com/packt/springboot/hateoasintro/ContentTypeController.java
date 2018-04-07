package com.packt.springboot.hateoasintro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
    private static class Message extends ResourceSupport {
        private String message;
    }


    /**
     * GET with URL parameter (and get a greeting back)
     */
    @GetMapping
    public Message greetFromPath(@RequestParam String addressee) {
        Message message = new Message("Hello " + addressee);
        message.add(linkTo(methodOn(ContentTypeController.class).greetFromPath(addressee)).withSelfRel());
        return message;
    }

}
