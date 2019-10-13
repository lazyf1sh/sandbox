package com.github.lazyf1sh.sandbox.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaStringHashingTest
{
    @Test
    public void main()
    {
        String s = "12";
        assertEquals(1569, s.hashCode());
    }

}