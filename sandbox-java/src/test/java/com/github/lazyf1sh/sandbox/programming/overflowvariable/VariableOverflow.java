package com.github.lazyf1sh.sandbox.programming.overflowvariable;

import org.junit.Test;

public class VariableOverflow
{
    @Test
    public void run()
    {
        int x = 10;
        do
        {
            x--;
            if (x > 0)
            {
                System.out.println("x>0: " + x);
            }
        }
        while (x < 10);
        System.out.println(x);
    }
}
