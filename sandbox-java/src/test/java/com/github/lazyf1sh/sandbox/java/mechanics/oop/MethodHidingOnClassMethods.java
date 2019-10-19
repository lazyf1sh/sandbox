package com.github.lazyf1sh.sandbox.java.mechanics.oop;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.mechanics.oop.inheritance.methodhiding.Child;
import com.github.lazyf1sh.sandbox.java.mechanics.oop.inheritance.methodhiding.Parent;

import static org.junit.Assert.assertEquals;


/**
 * Calling static methods on instances rather than classes is a very bad practice, and should never be done.<br/>
 * This examples only for the purpose of demostration.<br/>
 */
public class MethodHidingOnClassMethods
{
    @Test
    public void test()
    {
        Child instance = new Child();

        assertEquals("child", instance.getValue());
        Assert.assertEquals("parent", ((Parent) instance).getValue());

    }

    @Test
    public void test2()
    {
        Parent instance = new Child();

        assertEquals("parent", instance.getValue());
        assertEquals("child", ((Child) instance).getValue());
    }

    @Test
    public void test3()
    {
        Parent instance = new Parent();

        assertEquals("parent", instance.getValue());
    }

}
