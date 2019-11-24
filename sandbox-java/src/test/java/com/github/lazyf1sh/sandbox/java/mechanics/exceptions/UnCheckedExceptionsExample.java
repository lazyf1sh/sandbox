package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class UnCheckedExceptionsExample
{
    @Test
    public void basic_exception()
    {
        try
        {
            myMethod();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("a");
    }

    public void a()
    {
        if (1 != 2)
        {
            throw new RuntimeException();
        }
    }

    public void myMethod()
    {
        a();
    }
}
