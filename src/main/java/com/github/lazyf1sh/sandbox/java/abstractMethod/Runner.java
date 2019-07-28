package com.github.lazyf1sh.sandbox.java.abstractMethod;

/**
 * @author Ivan Kopylov
 */
public class Runner
{
    public static void main(String[] args)
    {
        SomeAbstractClassImplementor implementor = new SomeAbstractClassImplementor();
        implementor.concreteMethod();
    }
}
