package com.packt.springboot.restintro;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * This Spring MVC controller demonstrates very basic ways <i>not</i> to
 * return HTML, but data instead.
 *
 * @author Michael Piefel
 */
@Controller
public class HelloWorldController {

    /**
     * Produce plain text answer
     */
    @RequestMapping("/api/greeting/string")
    @ResponseBody
    public String string() {
        return "Greeting";
    }

    /**
     * Produce plain text answer that looks like JSON
     */
    @RequestMapping("/api/greeting/fakeJson")
    @ResponseBody
    public String fakeJson() {
        return "{\"message\":\"Hello world\"}";
    }

    /**
     * Produce JSON answer, constructed manually
     */
    @RequestMapping(path = "/api/greeting/manualJson",
            produces = "application/json")
    @ResponseBody
    public String manualJson() {
        return "{\"message\":\"Hello world\"}";
    }


    /**
     * Produce JSON from a map as return value. Can also be nested.
     */
    @RequestMapping("/api/greeting/mapJson")
    @ResponseBody
    public Map<String, Object> mapJson() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Hello from map");
        return result;
    }

    /**
     * The data wrapper that maps to JSON
     */
    @Data
    @AllArgsConstructor
    static class Message {
        private String message;
    }

    /**
     * Produce JSON from an object as return value.
     */
    @RequestMapping("/api/greeting/objectJson")
    @ResponseBody
    public Message objectJson() {
        return new Message("Hello from object");
    }

}
