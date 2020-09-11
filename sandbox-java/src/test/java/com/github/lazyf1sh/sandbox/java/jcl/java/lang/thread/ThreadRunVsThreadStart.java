package com.github.lazyf1sh.sandbox.java.jcl.java.lang.thread;

import org.junit.Assert;
import org.junit.Test;

public class ThreadRunVsThreadStart
{
    @Test
    public void start()
    {
        String parentThreadName = Thread.currentThread().getName();
        Thread thread = new Thread()
        {
            public void run()
            {
                String childThreadName = Thread.currentThread().getName();
                Assert.assertNotEquals(parentThreadName, childThreadName);
            }
        };

        thread.start(); //executes all required mechanisms to run a new thread.
    }

    @Test
    public void run()
    {
        String parentThreadName = Thread.currentThread().getName();
        Thread thread = new Thread()
        {
            public void run()
            {
                String childThreadName = Thread.currentThread().getName();
                Assert.assertEquals(parentThreadName, childThreadName);
            }
        };

        thread.run(); //just runs overridden method.
    }
}
