package com.github.lazyf1sh.sandbox.java.mechanics.numberformat;

import org.junit.Assert;
import org.junit.Test;

public class NumbersScientificNotation
{


    @Test
    public void scientificNotation()
    {

//        int x = 10e1; //uncompilable
//        float x = 10e1; //uncompilable

        double a1 = 10e1;
        double a2 = 10e01f;

        double a3 = 15e1f;
        double a4 = 15.5e1f;

        double a5 = 15.5e-0f;
        double a6 = 15.5e-1f;

        Assert.assertEquals(100.0, a1, 0);
        Assert.assertEquals(100.0, a2, 0);
        Assert.assertEquals(150.0, a3, 0);
        Assert.assertEquals(155.0, a4, 0);
        Assert.assertEquals(15.5, a5, 0);
        Assert.assertEquals(1.55, a6, 0.0000001);
    }
}
