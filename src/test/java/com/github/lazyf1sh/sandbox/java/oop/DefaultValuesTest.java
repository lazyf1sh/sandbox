package com.github.lazyf1sh.sandbox.java.oop;


import com.github.lazyf1sh.sandbox.java.oop.DefaultValues;
import org.junit.Test;

import static org.junit.Assert.*;


public class DefaultValuesTest
{
    @Test
    public void createDeployment()
    {
        DefaultValues defaultValues = new DefaultValues();

        assertEquals(defaultValues.str, null);
        assertEquals(defaultValues.myInt, 0);
        assertEquals(defaultValues.myBool, false);
    }



}
