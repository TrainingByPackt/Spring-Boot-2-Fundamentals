package com.packt.springboot.input.textareatag;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/textarea")
public class TextareaController {

    private TextareaTagCommand initTextareaTagCommand() {
        TextareaTagCommand textareaTagCommand = new TextareaTagCommand();
        textareaTagCommand.setSafeTextValue("This is the <em>safe</em> predefined value.");
        textareaTagCommand.setUnsafeTextValue("This is the <em>unsafe</em> predefined value.");

        return textareaTagCommand;
    }

    @ModelAttribute("textareaRows")
    public Integer textAreaRows() {
        return 10;
    }

    @GetMapping
    public ModelAndView renderForm() {
        return new ModelAndView("textareaform", "textareaTagCommand", initTextareaTagCommand());
    }

    @PostMapping
    public ModelAndView renderDisplay(@ModelAttribute("textareaTagCommand") TextareaTagCommand textareaInputTagCommand) {
        return new ModelAndView("textareadisplay", "textareaTagCommand", textareaInputTagCommand);
    }

}
