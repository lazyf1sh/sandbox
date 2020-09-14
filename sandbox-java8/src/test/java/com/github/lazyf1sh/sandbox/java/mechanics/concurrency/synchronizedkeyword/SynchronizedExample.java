package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.synchronizedkeyword;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ivan Kopylov
 */
public class SynchronizedExample
{
    @Test
    public void threadDangerousRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadDangerous summation = new CounterThreadDangerous();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertTrue(summation.getSum() < 1000);
    }

    @Test
    public void threadSafeRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadSafe summation = new CounterThreadSafe();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    public void threadSafeRun2() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadSafeBlock summation = new CounterThreadSafeBlock();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }


    public class CounterThreadSafe
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

    public class CounterThreadSafeBlock
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

    /**
     * @author Ivan Kopylov
     */
    public class CounterThreadDangerous
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
}