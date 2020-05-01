package com.github.lazyf1sh.sandbox.java.jcl.java.util.function;

import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.java8.streams.Foo;

/**
 * @author Ivan Kopylov
 */
public class SupplierExample
{
    private Foo    foo = new Foo();
    private String str = "1";

    @Test
    public void run()
    {
        foo.setMyString("1");

        final Supplier<String> s1 = foo::getMyString;
        final Supplier<String> s2 = () -> foo.getMyString();

        foo = new Foo();
        foo.setMyString("2");

        Assert.assertEquals("1", s1.get());
        Assert.assertEquals("2", s2.get());
    }

    @Test
    public void supplierNotLazyExampleString()
    {
        final Supplier<Integer> s1 = str::length;
        final Supplier<Integer> s2 = () -> str.length();

        str = "22";

        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}
