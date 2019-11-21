package com.github.lazyf1sh.sandbox.java.mechanics;

import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue.AbstractContainer;
import com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue.Dog;

import static org.junit.Assert.assertEquals;

/**
 * This example shows vairable reinitialization inside abstact method
 * @author Ivan Kopylov
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
