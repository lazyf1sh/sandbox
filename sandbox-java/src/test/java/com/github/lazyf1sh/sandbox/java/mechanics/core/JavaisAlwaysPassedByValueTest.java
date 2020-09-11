package com.github.lazyf1sh.sandbox.java.mechanics.core;

import com.github.lazyf1sh.sandbox.java.mechanics.oop.javaIsAlwaysPassByValue.Dog;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Java Spec says that everything in Java is pass-by-value.
 * There is no such thing as "pass-by-reference" in Java.
 * The thing is that the value of an object is a link to object
 *
 * @author Ivan Kopylov
 */
public class JavaisAlwaysPassedByValueTest
{
    @Test
    public void foo()
    {
        Dog dog = new Dog("Max");

        this.foo(dog);

        Assert.assertEquals("Max", dog.getName());  // dog variable is still pointing to the "Max" dog
        Assert.assertNotEquals("Fifi", dog.getName());
    }

    public void foo(Dog d)//d - is a link copy
    {
        Assert.assertEquals("Max", d.getName());
        d = new Dog("Fifi"); // change d inside of foo() to point to a new Dog instance "Fifi"
        Assert.assertEquals("Fifi", d.getName());
    }
}