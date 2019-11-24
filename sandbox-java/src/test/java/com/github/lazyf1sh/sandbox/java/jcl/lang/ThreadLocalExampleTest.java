package com.github.lazyf1sh.sandbox.java.jcl.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Threadlocal value is accesible only from thread it is created in.
 * @author Ivan Kopylov
 */
public class ThreadLocalExampleTest
{
    private static ThreadLocal<Integer> threadLocalValue1 = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocalValue2 = ThreadLocal.withInitial(() -> 2);

    @Test
    public void run()
    {
        threadLocalValue1.set(1);
        assertEquals(Integer.valueOf(1), threadLocalValue1.get());
        assertEquals(Integer.valueOf(2), threadLocalValue2.get());
    }

    @Test
    public void startAnotherThread()
    {
        Thread thread = new Thread()
        {
            public void run()
            {
                assertNull(threadLocalValue1.get());
                assertEquals(Integer.valueOf(2), threadLocalValue2.get());
                System.out.println("finished");
            }
        };
        thread.run();

    }

}