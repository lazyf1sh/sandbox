package com.github.lazyf1sh.sandbox.algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class MergeSortAttemptOneTest
{
    @Test
    public void dasdsa()
    {
        int[] arr = new int[]{9, 20, 48, 7, 1, 35, 5, 13};
        int[] result = new MergeSortAttemptOne().sort(arr);
        int[] expected = new int[]{1, 5, 7, 9, 13, 20, 35, 48};
        Assert.assertArrayEquals(expected, result);
    }
}

