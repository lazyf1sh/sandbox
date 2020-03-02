package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class fib1
{
    @Test
    public void main()
    {
        int fibonacci = fibonacci(6);
        System.out.println(fibonacci);
    }

    private int fibonacci(int n)
    {

        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
