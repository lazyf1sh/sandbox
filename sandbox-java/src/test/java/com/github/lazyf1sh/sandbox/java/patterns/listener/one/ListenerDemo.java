package com.github.lazyf1sh.sandbox.java.patterns.listener.one;

import org.junit.Test;

public class ListenerDemo
{
    @Test
    public void run()
    {

        LongRunningTask longRunningTask = new LongRunningTask(new OnCompleteListener()
        {
            @Override
            public void onComplete()
            {
                System.out.println("Yeah, the long running task has been completed!");
            }
        });

        System.out.println("Starting the long running task.");
        longRunningTask.run();
    }
}