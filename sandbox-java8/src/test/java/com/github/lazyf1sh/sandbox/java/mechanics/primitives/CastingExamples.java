package com.github.lazyf1sh.sandbox.java.mechanics.primitives;

import org.junit.Assert;
import org.junit.Test;

public class CastingExamples
{

    /**
     * Automatic type conversion. No explicit cast required.
     */
    @Test
    public void wideningCasting()
    {
        byte b = 40;
        // No casting needed for below conversion, because automatic widening is performed
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("byte value : " + b);
        System.out.println("short value : " + s);
        System.out.println("int value : " + i);
        System.out.println("long value : " + l);
        System.out.println("float value : " + f);
        System.out.println("double value : " + d);

        Assert.assertEquals(40, b);
        Assert.assertEquals(40, s);
        Assert.assertEquals(40, i);
        Assert.assertEquals(40, l);
        Assert.assertEquals(40L, f, 0);
        Assert.assertEquals(40, d, 0);
    }

    /**
     * Explicit cast required.
     */
    @Test
    public void narrowingCasting()
    {
        double d = 30.0;
        // Explicit casting is needed for below conversion
        float f = (float) d;
        long l = (long) f;
        int i = (int) l;
        short s = (short) i;
        byte b = (byte) s;
        System.out.println("double value : " + d);
        System.out.println("float value : " + f);
        System.out.println("long value : " + l);
        System.out.println("int value : " + i);
        System.out.println("short value : " + s);
        System.out.println("byte value : " + b);

        Assert.assertEquals(30.0, d, 0);
        Assert.assertEquals(30.0, f, 0);
        Assert.assertEquals(30, l);
        Assert.assertEquals(30, i);
        Assert.assertEquals(30, s);
        Assert.assertEquals(30, b);
    }


    /**
     * Implicit narrowing is supported among byte, char, short, and int when literals are used.
     */
    @Test
    public void narrowingCastingImplicit()
    {
        byte b1 = 127; //implicit cast from integer to byte.
//        char c1 = -1;
//        char c2 = 65536;
        char c2 = 65535;
        Assert.assertEquals(127, b1);
        Assert.assertEquals(65535, c2);
    }


    @Test
    public void narrowingCastingImplicit1()
    {
        int i1 = 5000;
//        byte b1 = i1;//d'oh, only for literals
    }

    /**
     * Implicit narrowing is permitted only among byte, char, short, and int.
     */
    @Test
    public void narrowingCastingFloatingPointNumbers()
    {
//        float f1 = 1.0; //attempt to cast double to float
        float f2 = 1.0f; //legal notation, works fine
    }


}
