package com.github.lazyf1sh.sandbox.java.jcl.java.util.concurrent;

/**
 * @author Ivan Kopylov
 */
public class Counter
{
    private int sum = 0;

    public void calculate()
    {
        setSum(getSum() + 1);
    }

    public int getSum()
    {
        return sum;
    }

    public void setSum(final int sum)
    {
        this.sum = sum;
    }
}