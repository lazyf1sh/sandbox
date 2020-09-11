package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class ExceptionsBasic
{
    /**
     * Exception (aka checked exceptions) and its successors must be handled.
     */
    @Test
    public void basic_exception()
    {
        try
        {
            throw new Exception("Exception cause msg.");
        }
        catch (Exception e)
        {
            System.out.println("Something bad happened.");
        }
    }

    /**
     * RuntimeException (aka unchecked exceptions) and its successors are optional to handle.
     */
    @Test(expected = RuntimeException.class)
    public void runtime()
    {
        throw new RuntimeException("Exception cause msg.");
    }

}
