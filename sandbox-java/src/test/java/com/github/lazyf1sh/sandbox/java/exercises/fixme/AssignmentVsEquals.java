package com.github.lazyf1sh.sandbox.java.exercises.fixme;

import org.junit.Assert;
import org.junit.Test;

/**
 * Assignment vs equals
 *
 * @author Ivan Kopylov
 */
public class AssignmentVsEquals
{
    @Test
    public void dsa()
    {
        boolean x = true;
        boolean y = false;
        while (x = y)// should be x == y
        {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }
}