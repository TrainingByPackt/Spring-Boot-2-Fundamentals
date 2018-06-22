package com.packt.springboot.blogmania.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("randomizer")
@Primary
@Profile("test")
public class FakeRandom implements Randomizer {
    @Override
    public double getRandom() {
        return 2.7182818284590452354;
    }
}
