package com.github.lazyf1sh.sandbox.java.mechanics.oop.initblock;

import org.junit.Test;

public class StaticBlockInitOrder
{
    @Test
    public void run()
    {
        Parent p = new Child();
    }

}

class Parent
{
    static
    {
        System.out.println("Parent static block initialized first.");
    }
}

class Child extends Parent
{
    static
    {
        System.out.println("Child static block initialized second.");
    }
}