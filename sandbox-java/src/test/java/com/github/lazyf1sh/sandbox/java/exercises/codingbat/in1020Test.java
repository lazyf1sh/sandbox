package com.github.lazyf1sh.sandbox.java.exercises.codingbat;

import com.github.lazyf1sh.sandbox.java.exercises.solutions.in1020;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class in1020Test
{

    @Test
    public void in1020()
    {
        assertTrue(in1020.in1020(10, 20));
        assertTrue(in1020.in1020(20, 20));
        assertFalse(in1020.in1020(30, 21));
    }
}