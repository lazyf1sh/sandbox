package com.github.lazyf1sh.sandbox.patterns.singleton;

/**
 * @author Ivan Kopylov
 */
public class MyEnumSingletonMock implements MyEnumSingleton
{
    @Override
    public String someMethod()
    {
        return "mock";
    }
}
