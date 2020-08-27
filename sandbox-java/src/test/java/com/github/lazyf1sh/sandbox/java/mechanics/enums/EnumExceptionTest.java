package com.github.lazyf1sh.sandbox.java.mechanics.enums;


import org.junit.Assert;
import org.junit.Test;

public class EnumExceptionTest
{
    @Test(expected = IllegalArgumentException.class)
    public void exceptionNonExistingEnumValue()
    {
        EnumToString.valueOf("some non-existing value");
    }

    @Test
    public void enumToString()
    {
        EnumToString myValue1 = EnumToString.MY_VALUE;
        String myValue2 = EnumToString.MY_VALUE.toString();
        String myValue3 = EnumToString.MY_VALUE.name();
        String myValue4 = EnumToString.MY_VALUE.getEnumValue();

        Assert.assertEquals(EnumToString.MY_VALUE, myValue1);
        Assert.assertEquals("MY_VALUE", myValue2);
        Assert.assertEquals("MY_VALUE", myValue3);
        Assert.assertEquals("QWERTY", myValue4);
    }
}
