package com.github.lazyf1sh.sandbox.java.mechanics.operatorPrecedence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Operators evaluation order.
 */
public class OperatorPrecedence
{
    @Test
    public void calculateYourselfFirst1()
    {
        int x = 5;
        int y = 10;
        int result = ++x * y--;
//        Assert.assertEquals(, result);
    }

    @Test
    public void calculateYourselfFirst2()
    {
        String result1 = "1 + 2 = " + 1 + 2;
        String result2 = "1 + 2 = " + (1 + 2);

//        Assert.assertEquals("", result1);
//        Assert.assertEquals("", result2);
    }

    @Test
    public void calculateYourselfFirst4()
    {
        String result1 = 1 + 2 + "abc";
        String result2 = "abc" + 1 + 2;

//        Assert.assertEquals("", result1);
//        Assert.assertEquals("", result2);
    }


    /**
     * Also, add clarifying parentheses.
     */
    @Test
    public void calculateYourselfFirst3()
    {
        int year = 2020;
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
//        Assert.assertEquals(, result);
    }
}
