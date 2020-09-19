package com.github.lazyf1sh.sandbox.patterns.singleton.singletonmockfailed;

/**
 * This enum will actually be compiled to something like:
 * <p/>
 * public final class MySingleton {
 *     public final static MySingleton INSTANCE = new MySingleton();
 *     private MySingleton(){}
 * }
 *
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
