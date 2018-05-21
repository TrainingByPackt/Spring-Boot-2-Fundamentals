package com.packt.springboot.input.selecttag;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/select")
public class SelectTagController {

    @ModelAttribute("allSelectOptions")
    public List<String> allSelectOptions() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(value -> format("dynamicSelectValue%d", value))
                .collect(toList());
    }

    private SelectTagCommand initSelectTagCommand() {
        SelectTagCommand selectTagCommand = new SelectTagCommand();
        selectTagCommand.setSingleListValue("dynamicSelectValue3");
        selectTagCommand.setMultipleListValue(new String[]{"dynamicSelectValue2", "dynamicSelectValue4"});

        return selectTagCommand;
    }

    @GetMapping
    public ModelAndView renderForm() {
        return new ModelAndView("selectform", "selectTagCommand", initSelectTagCommand());
    }

    @PostMapping
    public ModelAndView renderDisplay(@ModelAttribute("selectTagCommand") SelectTagCommand selectInputTagCommand) {
        return new ModelAndView("selectdisplay", "selectTagCommand", selectInputTagCommand);
    }
}
