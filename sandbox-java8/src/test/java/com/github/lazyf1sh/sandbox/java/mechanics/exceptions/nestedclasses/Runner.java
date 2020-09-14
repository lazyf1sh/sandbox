package com.github.lazyf1sh.sandbox.java.mechanics.exceptions.nestedclasses;

import org.junit.Test;

public class Runner
{
    @Test
    public void haveToWrapWithTry()
    {
        Parent b = new Child();
        try
        {
            b.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void dontHaveToWrapWithTry()
    {
        Child b = new Child();
        b.run();
    }

}
