package com.github.lazyf1sh.sandbox.java.mechanics.primitives;

import org.junit.Assert;
import org.junit.Test;

public class ImplicitNarrowing
{

    @Test
    public void run1()
    {
        int i1 = 100;
        byte b1 = (byte) i1;
        System.out.println(b1);
        Assert.assertEquals(100, b1);
    }

    @Test
    public void run2()
    {
        int i1 = 127;
        byte b1 = (byte) i1;
        Assert.assertEquals(127, b1);
    }

    @Test
    public void run3()
    {
        int i1 = 128;
        byte b1 = (byte) i1;
        Assert.assertEquals(-128, b1);
    }

    @Test
    public void run4()
    {
        int i1 = 255;
        byte b1 = (byte) i1;
        Assert.assertEquals(-1, b1);
    }


}
