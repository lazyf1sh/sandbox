package com.github.lazyf1sh.sandbox.java.operators.plus;

import org.junit.Test;

public class PlusOperationBetweenClasses
{

    @Test
    public void twoClassesCompileError()
    {
//        System.out.println(new ClassOne() + new ClassTwo());
    }

    @Test
    public void oneOfTheClassesIsStringNoCompileError()
    {
        System.out.println("My string " + new ClassTwo());
        System.out.println(new String("My string ") + new ClassTwo());
    }
}
