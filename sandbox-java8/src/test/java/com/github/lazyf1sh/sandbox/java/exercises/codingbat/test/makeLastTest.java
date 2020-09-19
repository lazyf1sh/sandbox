package com.github.lazyf1sh.sandbox.java.exercises.codingbat.test;

import com.github.lazyf1sh.sandbox.java.exercises.codingbat.impl.makeLast;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class makeLastTest
{
    @Test
    public void makeLast()
    {
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 6}, makeLast.makeLast(new int[]{4, 5, 6}));
    }
}