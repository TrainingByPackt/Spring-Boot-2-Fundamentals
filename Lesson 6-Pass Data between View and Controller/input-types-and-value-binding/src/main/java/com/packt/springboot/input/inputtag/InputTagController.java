package com.packt.springboot.input.inputtag;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/input")
public class InputTagController {

    @ModelAttribute("dynamicRadioOptions")
    public List<String> dynamicRadioOptions() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(value -> format("dynamicValue%d", value))
                .collect(toList());
    }

    private InputTagCommand initInputTagCommand() {
        InputTagCommand inputTagCommand = new InputTagCommand();
        inputTagCommand.setHiddenValue("A hidden value");
        inputTagCommand.setRadioValue("Radio Value 2");
        return inputTagCommand;
    }

    @GetMapping
    public ModelAndView renderForm() {
        return new ModelAndView("inputform", "inputTagCommand", initInputTagCommand());
    }

    @PostMapping
    public ModelAndView renderDisplay(@ModelAttribute("initInputTagCommand") InputTagCommand initInputTagCommand) {
        return new ModelAndView("inputdisplay", "inputTagCommand", initInputTagCommand);
    }
}
