package com.github.lazyf1sh.sandbox.java.mechanics.primitives;

import org.junit.Assert;
import org.junit.Test;

public class DoublePrecisionProblem
{
    @Test
    public void a()
    {
        for (float value = 0.0f; value < 1.0f; value += 0.1f)
        {
            System.out.println(value);
        }
    }

    @Test
    public void b()
    {
        double d = 0.3;
        double result = d * 3;
        System.out.println(result);
        Assert.assertEquals(0.8999999999999999, result, 0);
    }
}
