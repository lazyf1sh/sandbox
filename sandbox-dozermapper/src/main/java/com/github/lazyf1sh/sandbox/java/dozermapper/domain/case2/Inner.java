package com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2;

/**
 * @author Ivan Kopylov
 */
public class Inner
{
    public static String value = "overrided toString() value";

    @Override
    public String toString()
    {
        return value;
    }
}
