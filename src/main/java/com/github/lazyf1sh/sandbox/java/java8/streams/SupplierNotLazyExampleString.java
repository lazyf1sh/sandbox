package com.github.lazyf1sh.sandbox.java.java8.streams;

import java.util.function.Supplier;

public class SupplierNotLazyExampleString
{
    private static String s = "333";


    public static void main(String[] args)
    {
        Foo foo = new Foo();

        final Supplier<Integer> s1 = s::length;
        final Supplier<Integer> s2 = () -> s.length();

        s = "4444";

        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}
