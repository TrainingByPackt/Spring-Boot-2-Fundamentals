package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShortMessageService {

    private final ShortMessageRepository shortMessageRepository;

    public List<ShortMessage> findAll() {
        List<ShortMessage> shortMessages = shortMessageRepository.retrieveAll();
        // If you want to use @PostFilter, use a modifiable copy!
        return new ArrayList<>(shortMessages);
    }
}
