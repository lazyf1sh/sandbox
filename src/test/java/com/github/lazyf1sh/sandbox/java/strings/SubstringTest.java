package com.github.lazyf1sh.sandbox.java.strings;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SubstringTest
{
    @Test
    public void test()
    {
        String s = "0123456789_A";

        assertEquals("0123", s.substring(0, 4));
        assertEquals("456789", s.substring(4, 10));
        assertEquals("1" + null, "1null");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testException()
    {

        String s = "0123456789_A";
        int endIndex = "qwee".lastIndexOf("_________"); //returns -1
        s.substring(0, endIndex); //throws exception
    }
}