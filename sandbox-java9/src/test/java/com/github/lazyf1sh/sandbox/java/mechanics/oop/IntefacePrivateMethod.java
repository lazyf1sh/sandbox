package com.github.lazyf1sh.sandbox.java.mechanics.oop;

import org.junit.Assert;
import org.junit.Test;

public class IntefacePrivateMethod
{
    @Test
    public void run()
    {
        InterfaceWithAPrivateMethod interfaceWithAPrivateMethod = new InterfaceWithAPrivateMethod()
        {

        };
        Assert.assertEquals("foo", interfaceWithAPrivateMethod.bar());
    }
}
