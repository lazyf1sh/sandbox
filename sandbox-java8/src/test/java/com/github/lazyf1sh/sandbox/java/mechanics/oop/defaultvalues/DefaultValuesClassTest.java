package com.github.lazyf1sh.sandbox.java.mechanics.oop.defaultvalues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Purpose: to demonstate object properties default values
 */
public class DefaultValuesClassTest
{
    @Test
    public void objectDefaultValues()
    {
        DefaultValuesClass defaultValues = new DefaultValuesClass();

        assertNull(defaultValues.str);
        assertEquals(defaultValues.myInt, 0);
        assertFalse(defaultValues.myBool);
    }

    @Test
    public void objectDefaultValues2()
    {
        int[] array = new int[3];//initialized with zeros

        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
        assertEquals(0, array[2]);
    }

}
