package com.github.lazyf1sh.sandbox.patterns.singleton;

/**
 * @author Ivan Kopylov
 */
public enum MyEnumSingletonImpl implements MyEnumSingleton
{
    INSTANCE;

    private MyEnumSingletonImpl()
    {

    }

    public String someMethod()
    {
        return "test";
    }
}
