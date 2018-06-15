package com.packt.springboot.databaseintro.logic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ShortMessage {

    private List<Author> authors;

    private LocalDateTime postedTime;

    private String messageText;

}
