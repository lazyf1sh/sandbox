package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.synchronizedkeyword;

/**
 * @author Ivan Kopylov
 */
public class CalculatorSynchronized
{
    private int sum = 0;

    public synchronized void calculate()
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
