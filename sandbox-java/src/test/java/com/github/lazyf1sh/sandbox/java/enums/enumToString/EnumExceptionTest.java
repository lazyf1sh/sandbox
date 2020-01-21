package com.github.lazyf1sh.sandbox.java.enums.enumToString;


import org.junit.Test;

public class EnumExceptionTest
{

    @Test
    public void run()
    {
        try
        {
            EnumToString enumToString = EnumToString.valueOf("a");
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
