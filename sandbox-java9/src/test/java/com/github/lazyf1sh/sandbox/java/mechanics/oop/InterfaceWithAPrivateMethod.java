package com.github.lazyf1sh.sandbox.java.mechanics.oop;

public interface InterfaceWithAPrivateMethod
{
    default String bar()
    {
        return foo();
    }

    private String foo()
    {
        return "foo";
    }
}
