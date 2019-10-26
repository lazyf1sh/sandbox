package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.exercises.solutions.makeLast;

/**
 * @author Ivan Kopylov
 */
public class makeLastTest
{
    @Test
    public void makeLast()
    {
        Assert.assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 6 }, makeLast.makeLast(new int[] { 4, 5, 6 }));
    }
}