package com.packt.springboot.input.selecttag;

import lombok.Data;

@Data
public class SelectTagCommand {
    private String singleSelectValue;
    private String singleListValue;
    private String[] multipleListValue;
}
