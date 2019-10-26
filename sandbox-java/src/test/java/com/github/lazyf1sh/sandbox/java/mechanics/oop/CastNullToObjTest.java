package com.github.lazyf1sh.sandbox.java.mechanics.oop;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class CastNullToObjTest
{
    /**
     * You can cast null to any reference type without getting any exception.
     */
    @Test
    public void run()
    {
        String str = (String)null; //no exception

        Assert.assertTrue(true);
    }
}