package com.github.lazyf1sh.sandbox.java.mechanics.oop.initblock;

import org.junit.Test;

public class StaticVsNonStatic
{

    @Test
    public void main()
    {
        new MyClass();
        new MyClass();
    }
}

class MyClass
{

    static
    {
        System.out.println("Static");
    }

    {
        System.out.println("Non-static block");
    }

}
