package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class ExceptionsExample
{
    @Test
    public void basic_exception()
    {
        try
        {
            myMethod();
            System.out.println("Will not be executed.");
        }
        catch (Exception e)
        {
            System.out.println("Something bad happened.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void myMethod() throws Exception
    {
        if (1 != 2)
        {
            throw new Exception("Exception cause msg.");
        }
    }
}
