package com.github.lazyf1sh.sandbox.patterns.delegating;

/**
 * @author Ivan Kopylov
 */
public class Delegated2
{
    private Base base = new Base();

    private String childSpecificField;

    public void childSpecificMethod()
    {
        System.out.println(base.str1);
    }

    public void someAction1()
    {
        base.someAction1();
    }

    public void someAction2()
    {
        base.someAction2();
    }



}
