package com.packt.springboot.blogmania.exercise;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component("randomizer")
//@Profile("!test") // this is another was if you don't use @Primary on the other bean
public class RealRandom implements Randomizer {
    @Override
    public double getRandom() {
        try {
            return SecureRandom.getInstanceStrong().nextDouble();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not initialize random number generator",e);
        }
    }
}
