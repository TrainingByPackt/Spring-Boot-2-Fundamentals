package com.packt.springboot.securityintro.logic;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ShortMessageService {
    private List<ShortMessage> shortMessages = new LinkedList<>();

    /** Low-level access, unsecured */
    void add(Author author, LocalDateTime postedTime, String messageText) {
        ShortMessage shortMessage = new ShortMessage(author, postedTime, messageText);
        shortMessages.add(shortMessage);
    }

    public List<ShortMessage> findAll() {
        // If you want to use @PostFilter, use a modifiable copy!
        return new ArrayList<>(shortMessages);
    }
}
