package com.github.lazyf1sh.sandbox.java.java8.streams;

import java.util.function.Supplier;

public class SupplierNotLazyExampleObj
{
    private static Foo foo = new Foo();

    public static void main(String[] args)
    {
        foo.setS("333");
        final Supplier<String> s1 = foo::getS;
        final Supplier<String> s2 = () -> foo.getS();

        foo = new Foo();
        foo.setS("4444");

        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}
