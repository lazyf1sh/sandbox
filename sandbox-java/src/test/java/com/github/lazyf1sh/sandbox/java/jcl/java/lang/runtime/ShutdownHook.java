package com.github.lazyf1sh.sandbox.java.jcl.java.lang.runtime;

import org.junit.Test;

public class ShutdownHook
{

    @Test
    public void addHook()
    {
        System.out.println("Adding shut down hook.");
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown hook has executed.");
                for (int i = 3; i > 0; i--)
                {
                    try
                    {
                        Thread.sleep(1000);
                        System.out.println("shutdown in " + i);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
