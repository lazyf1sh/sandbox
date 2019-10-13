package com.github.lazyf1sh.sandbox.java.mechanics;


import com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue.AbstractContainer;
import com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue.Dog;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This example shows ...
 * Example level: medium
 */
public class ReinitInsideAnonymousMethod
{
    private Dog dog;

    @Test
    public void test1()
    {
        dog = new Dog("Ace");

        AbstractContainer abstractContainer = new AbstractContainer(dog)
        {
            @Override
            public void myMethod()
            {
                dog = new Dog("Apollo");
            }
        };

        assertEquals("Ace", abstractContainer.getDog().getName());
        assertEquals("Apollo", dog.getName());
    }
}
