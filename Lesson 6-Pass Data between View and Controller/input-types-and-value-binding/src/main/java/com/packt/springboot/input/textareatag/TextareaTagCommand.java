package com.packt.springboot.input.textareatag;

import lombok.Data;

@Data
public class TextareaTagCommand {
    private String safeTextValue;
    private String unsafeTextValue;
}
