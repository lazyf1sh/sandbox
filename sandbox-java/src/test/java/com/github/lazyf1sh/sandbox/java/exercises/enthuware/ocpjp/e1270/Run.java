package com.github.lazyf1sh.sandbox.java.exercises.enthuware.ocpjp.e1270;

import org.junit.Test;

public class Run
{

    @Test
    public void run()
    {
        boolean b = false;
        int i = 1;
        do
        {
            i++;
        }
        while (b = !b);
        System.out.println(i);
    }
}
