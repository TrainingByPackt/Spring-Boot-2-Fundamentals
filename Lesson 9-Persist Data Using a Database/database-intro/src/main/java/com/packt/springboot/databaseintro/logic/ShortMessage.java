package com.packt.springboot.databaseintro.logic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ShortMessage {

    private Author author;

    private LocalDateTime postedTime;

    private String messageText;

}
