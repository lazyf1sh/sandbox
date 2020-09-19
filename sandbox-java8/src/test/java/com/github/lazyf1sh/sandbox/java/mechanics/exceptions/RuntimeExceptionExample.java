package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class RuntimeExceptionExample
{
    @Test
    public void main()
    {
        System.out.println("1");
        try
        {
            throwException();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("2");
    }

    private static void throwRuntime()
    {
        throw new RuntimeException("my exception");
    }

    private static void throwException() throws Exception
    {
        throw new Exception("my exception");
    }
}
