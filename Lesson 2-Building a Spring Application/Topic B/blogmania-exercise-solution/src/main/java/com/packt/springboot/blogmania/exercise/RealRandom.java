package com.packt.springboot.blogmania.exercise;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("randomizer")
//@Profile("!test") // this is another way if you don't use @Primary on the other bean
public class RealRandom implements Randomizer {
    @Override
    public double getRandom() {
        return ThreadLocalRandom.current().nextDouble();
    }
}
