package com.github.lazyf1sh.algorithms;

public class FibAttemptTwo {

    public static void main(String args[])
    {
        FibAttemptTwo fibAttemptTwo = new FibAttemptTwo();
        long i = fibAttemptTwo.fib2(40);
        System.out.println(i);
    }

    public long fib2(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }

        long[] arr = new long[Integer.MAX_VALUE - 5];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; i++)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];

    }

}
