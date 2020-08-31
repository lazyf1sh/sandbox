package com.github.lazyf1sh.sandbox.java.mechanics.oop.hiding;

import org.junit.Assert;
import org.junit.Test;

public class FinalFieldHiding
{
    @Test
    public void reference_type_b()
    {
        Child child = new Child();
        Assert.assertEquals(20, child.f1);
        Assert.assertEquals(10, ((Parent) child).f1);

        Assert.assertEquals("test", child.f2);
        Assert.assertEquals(10, ((Parent) child).f2);
    }
     @Test
    public void reference_type_a()
    {
        Parent parent = new Child();
        Assert.assertEquals(10, parent.f1);
        Assert.assertEquals(20, ((Child) parent).f1);

        Assert.assertEquals(10, parent.f2);
        Assert.assertEquals("test", ((Child) parent).f2);
    }

}

class Parent
{
    final int f1 = 10;
    final int f2 = 10;
}

class Child extends Parent
{
    int    f1 = 20;
    String f2 = "test";
}

