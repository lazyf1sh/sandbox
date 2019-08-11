package com.github.lazyf1sh.sandbox.java.oop.inheritance.methodoverriding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Compare this with instance methods, which are polymorphic and are thus overridden. The method called depends on the concrete, runtime type of the object:
 */
public class MethodHidingOnInstanceMethods
{
    @Test
    public void test()
    {
        Child child = new Child();

        assertEquals("child", child.getValue());
        assertEquals("child", ((Parent) child).getValue());//may be strange, but it also returns child

    }

    @Test
    public void test2()
    {
        Parent child = new Child();

        assertEquals("child", child.getValue());
        assertEquals("child", ((Parent) child).getValue());//may be strange, but it also returns child
    }

    @Test
    public void test3()
    {
        Parent child = new Parent();

        assertEquals("parent", child.getValue());
    }

}
