package com.github.lazyf1sh.sandbox.java.exercises.hyperskill;

import org.junit.Assert;
import org.junit.Test;

public class step2187
{
    @Test
    public void run()
    {
        int a = 3;
        int b = 22;

        int sum = 0;

        for (int i = a; i <= b; i++)
        {
            System.out.println(i);
            sum += i;
        }

        Assert.assertEquals(250, sum);
    }
}
