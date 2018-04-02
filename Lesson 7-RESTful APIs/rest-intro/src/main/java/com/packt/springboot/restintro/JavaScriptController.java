package com.packt.springboot.restintro;

import jdk.nashorn.internal.runtime.ParserException;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Controller to allow JavaScript evaluation.
 * Just a toy, don’t do this at home, kids!
 *
 * @author Michael Piefel
 */
@RestController
public class JavaScriptController {
    @Value
    private static class Message {
        private String message;
    }

    // use Nashorn, the Java built-in JavaScript interpreter
    private ScriptEngine javaScript = new ScriptEngineManager()
            .getEngineByName("JavaScript");

    /** Try to evaluate the given JavaScript */
    @PostMapping("/api/computation")
    public Message eval(@RequestParam(required = false) String expression)
            throws ScriptException {
        if (expression == null || expression.equals("")) {
            throw new IllegalArgumentException("Need non-blank expression");
        }
        Object eval = javaScript.eval(expression);
        return new Message("Evaluation of " + expression + " yields " + eval);
    }

    // handle the explicitly thrown runtime exception
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleArgument(IllegalArgumentException e) {
        return e.getMessage();
    }

    // handle the parser’s exceptions
    @ExceptionHandler({ParserException.class, ScriptException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleParse(Exception e) {
        return e.getMessage();
    }
}
