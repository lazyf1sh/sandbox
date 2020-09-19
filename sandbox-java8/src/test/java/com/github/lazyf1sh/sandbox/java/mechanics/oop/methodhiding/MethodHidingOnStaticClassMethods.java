package com.github.lazyf1sh.sandbox.java.mechanics.oop.methodhiding;

import com.github.lazyf1sh.sandbox.java.mechanics.oop.methodhiding.Child;
import com.github.lazyf1sh.sandbox.java.mechanics.oop.methodhiding.Parent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Calling static methods on instances rather than classes is a very bad practice, and should never be done.<br/>
 * This examples only for the purpose of demostration.<br/>
 */
public class MethodHidingOnStaticClassMethods
{
    @Test
    public void test()
    {
        Child child = new Child();

        assertEquals("child", child.getValue());
        assertEquals("parent", ((Parent) child).getValue());

        assertEquals("child", Child.getValue());
        assertEquals("parent", Parent.getValue());
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
