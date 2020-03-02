package com.github.lazyf1sh.sandbox.java.mechanics.ctor.privateCtor;


public class MyPrivateCtorClass
{
    private static String value = "old value";

    private MyPrivateCtorClass()
    {
        value = "private ctor updated value";
    }

    static
    {
        value = "static initializer updated value";
    }

    public static String getValue()
    {
        return value;
    }
}
