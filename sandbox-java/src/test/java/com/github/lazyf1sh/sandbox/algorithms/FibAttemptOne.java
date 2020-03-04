package com.github.lazyf1sh.sandbox.algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Exponential algorithm
 * https://imgur.com/a/qo9qMhK
 */
public class FibAttemptOne
{
    private int calls = 0;

    @Test
    public void main()
    {

        FibAttemptOne fibOne = new FibAttemptOne();

        int result = fibOne.fib1(46);
        Assert.assertEquals(1836311903, result);
    }

    private int fib1(int n)
    {
        calls++;
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

}
