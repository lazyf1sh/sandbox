package com.github.lazyf1sh.sandbox.java.mechanics.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingCurlyBracketsTest
{

    @Test
    public void run()
    {
        int a = 0;
        int b = 0;
        int c = 0;


        if(false)
        a = 1;
        b = 1;


        if(false)
        {
            c = 1;
        }

        assertEquals(0, a);
        assertEquals(1, b);
        assertEquals(0, c);

    }
}
