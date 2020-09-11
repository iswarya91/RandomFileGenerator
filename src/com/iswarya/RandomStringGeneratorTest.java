package com.iswarya;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomStringGeneratorTest {

    @Test
    public void generateRandomString() {
        RandomStringGenerator rand = new RandomStringGenerator();
        String s = rand.generateRandomString(30);
        assertEquals(30, s.length());
    }
}