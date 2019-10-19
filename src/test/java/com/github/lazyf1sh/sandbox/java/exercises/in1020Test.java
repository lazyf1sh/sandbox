package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class in1020Test {

    @Test
    public void in1020() {
        assertTrue(in1020.in1020(10, 20));
        assertTrue(in1020.in1020(20, 20));
        assertFalse(in1020.in1020(30, 21));
    }
}