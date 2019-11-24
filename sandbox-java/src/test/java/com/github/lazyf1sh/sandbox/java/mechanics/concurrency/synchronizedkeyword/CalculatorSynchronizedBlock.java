package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.synchronizedkeyword;

/**
 * @author Ivan Kopylov
 */
public class CalculatorSynchronizedBlock
{
    private int sum = 0;

    public void calculate()
    {
        synchronized (this)
        {
            setSum(getSum() + 1);
        }

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
