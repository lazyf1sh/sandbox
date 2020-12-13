package com.github.lazyf1sh.sandbox.java.binding;

import org.junit.Assert;
import org.junit.Test;

public class DynamicBindingExampleTest
{
    @Test
    public void run()
    {
        A a = new A();
        A b = new B();

        System.out.println("a.i:" + a.i);
        System.out.println("b.i:" + b.i);

        Assert.assertEquals(10, a.i);
        Assert.assertEquals(10, b.i);
    }

    @Test
    public void run2()
    {
        A a = new A();
        B b = new B();

        System.out.println("a.i:" + a.i);
        System.out.println("b.i:" + b.i);

        Assert.assertEquals(10, a.i);
        Assert.assertEquals(20, b.i);
    }
}