package com.packt.springboot.blogmania.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component("randomizer") @Primary @Profile("test")
public class FakeRandom implements Randomizer {
    @Override
    public double getRandom() {
        try {
            return SecureRandom.getInstanceStrong().nextDouble();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not initialize random number generator",e);
        }
    }
}
