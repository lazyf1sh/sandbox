package com.github.lazyf1sh.sandbox.java.mechanics.primitives;

import org.junit.Assert;
import org.junit.Test;

public class Float
{

    @Test
    public void mistakes()
    {
//        float f1 = 1.0; //not compilable, because it is a double
//        float f2 = 43e1; //not compilable, because it is a double
    }

    @Test
    public void run1()
    {
        float f2 = 1.0f;
        Assert.assertEquals(1, f2);
    }

    @Test
    public void run3()
    {
        float hex1 = 0xA;
        float hex2 = 0x0A;
        float hex3 = 0x00000A;
        float hex4 = 0x00_000_A;

        Assert.assertEquals(hex1, hex2, 0);
        Assert.assertEquals(hex1, hex3, 0);
        Assert.assertEquals(hex1, hex4, 0);
    }

    @Test
    public void run4()
    {
        float f1 = -1;

        Assert.assertEquals(-1, f1, 0);
    }

    @Test
    public void run5()
    {
        float f1 = java.lang.Float.MAX_VALUE;

        System.out.println(f1);
    }


}
