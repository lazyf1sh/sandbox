package com.github.lazyf1sh.sandbox.java.abstractMethod;

/**
 * Purpose: base class for declaring abstract method.
 * @author Ivan Kopylov
 */
public abstract class SomeAbstractClass
{
    public abstract void someMethod();

    void concreteMethod()
    {
        someMethod();
    }
}
