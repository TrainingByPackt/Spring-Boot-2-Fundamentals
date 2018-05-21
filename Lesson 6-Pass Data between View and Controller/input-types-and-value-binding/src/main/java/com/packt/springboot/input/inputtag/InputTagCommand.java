package com.packt.springboot.input.inputtag;

import lombok.Data;

@Data
public class InputTagCommand {
    private String textValue;
    private Long numberValue;
    private String hiddenValue;
    private boolean checkboxValue;
    private String radioValue;
    private String dynamicRadioValue;
    private String passwordValue;
}
