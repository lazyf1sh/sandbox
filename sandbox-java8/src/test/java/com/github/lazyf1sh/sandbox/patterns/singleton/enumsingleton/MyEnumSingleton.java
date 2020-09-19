package com.github.lazyf1sh.sandbox.patterns.singleton.enumsingleton;

public enum MyEnumSingleton
{
    INSTANCE;

    public static final String RETURN_RESULT = "some calculated value";

    private MyEnumSingleton()
    {

    }

    public String utilMethod()
    {
        return RETURN_RESULT;
    }
}
