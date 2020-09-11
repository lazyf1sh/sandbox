package com.github.lazyf1sh.sandbox.java.jcl.java.lang.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Basic demonstration of strings pool in java. Strings are compared intentionally using reference equality.
 */
public class StringsPool
{
    @Test
    public void test1()
    {
        String a = "012"; //goes into strings pool
        String b = "012"; //goes into strings pool
        String c = "0" + "1" + "2"; //goes into strings pool

        String d = null; // value is calculated
        for (int i = 0; i <= 2; i++)
        {
            d += i;
        }

        Assert.assertTrue(a == b);
        Assert.assertTrue(c == a);
        Assert.assertTrue(c == b);


        Assert.assertFalse(d == a);
        Assert.assertFalse(d == b);
        Assert.assertFalse(d == c);
    }

    @Test
    public void test2()
    {
        String a = new String("012");
        String b = new String("012");
        Assert.assertFalse(a == b);
    }

    @Test
    public void test3()
    {
        String a = new String("012");
        String b = new String("012");
        Assert.assertFalse(a == b);
        Assert.assertFalse(a == b.intern());
    }

    @Test
    public void test4()
    {
        String a = new String("012");
        String b = new String("012");
        Assert.assertTrue(a.intern() == b.intern());
    }

    @Test
    public void test5()
    {
        String a = "012";
        String b = new String("012");
        Assert.assertTrue(a == b.intern());
    }

}
