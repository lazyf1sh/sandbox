package com.github.lazyf1sh.sandbox.java.jcl.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Threadlocal value is accesible only from thread it is created in.
 *
 * @author Ivan Kopylov
 */
public class ThreadLocalExampleTest
{
    private static ThreadLocal<Integer> THREAD_LOCAL_ONE = new ThreadLocal<>();
    private static ThreadLocal<Integer> THREAD_LOCAL_TWO = ThreadLocal.withInitial(() -> 2);

    @Test
    public void run()
    {
        THREAD_LOCAL_ONE.set(1);
        assertEquals(Integer.valueOf(1), THREAD_LOCAL_ONE.get());
        assertEquals(Integer.valueOf(2), THREAD_LOCAL_TWO.get());
    }

    @Test
    public void startAnotherThread()
    {
        Thread thread = new Thread()
        {
            public void run()
            {
                assertNull(THREAD_LOCAL_ONE.get());
                assertEquals(Integer.valueOf(2), THREAD_LOCAL_TWO.get());
                System.out.println("finished");
            }
        };
        thread.start();

    }

}