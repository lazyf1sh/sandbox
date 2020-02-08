package com.github.lazyf1sh.sandbox.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BitFieldExample
{


    private static final int MAGIC = 1;
    private static final int AGILITY = 2;
    private static final int INTELLIGENCE = 4;
    private static final int CHARISMA = 8;
    private static final int WILLPOWER = 16;
    private static final int POWER = 32;

    private static final long REGENERATION = 8589934592L; // power of 33
    private static final long STAMINA = 9223372036854775807L; //power of 63


    @Test
    public void set_flag_1()
    {
        int attributes = POWER | WILLPOWER;
        Assert.assertEquals(48, attributes);
        Assert.assertEquals("110000", Integer.toBinaryString(attributes));
    }

    @Test
    public void leading_zero_is_negative_flag()
    {
        int to_31_power = Integer.MAX_VALUE; // 2147483647;
        int to_31_power_negative = Integer.MIN_VALUE; // -2147483648;

        Assert.assertEquals("01111111111111111111111111111111", String.format("%32s", Integer.toBinaryString(to_31_power)).replace(' ', '0'));
        Assert.assertEquals("10000000000000000000000000000000", String.format("%32s", Integer.toBinaryString(to_31_power_negative)).replace(' ', '0'));
    }

    @Test
    public void leading_zero_is_negative_flag_long()
    {
        long to_63_power = Long.MAX_VALUE;
        long to_63_power_negative = Long.MIN_VALUE;

        Assert.assertEquals("0111111111111111111111111111111111111111111111111111111111111111", String.format("%64s", Long.toBinaryString(to_63_power)).replace(' ', '0'));
        Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000", String.format("%64s", Long.toBinaryString(to_63_power_negative)).replace(' ', '0'));
    }


    @Test
    public void set_flag_long()
    {
        long attributes = POWER | REGENERATION;
        Assert.assertEquals("1000000000000000000000000000100000", Long.toBinaryString(attributes));
        Assert.assertEquals(8589934624L, attributes);
    }

    @Test
    public void set_flag_long_2()
    {
        long attributes = STAMINA | REGENERATION;
        Assert.assertEquals("1000000000000000000000000000100000", Long.toBinaryString(attributes));
        Assert.assertEquals(8589934624L, attributes);
    }


    @Test
    public void set_flag_2()
    {
        int attributes = POWER | WILLPOWER;
        attributes |= CHARISMA;
        Assert.assertEquals("111000", Integer.toBinaryString(attributes));
        Assert.assertEquals(56, attributes);
    }


    @Test
    public void unset_flag()
    {
        int attributes = POWER | WILLPOWER;
        attributes &= ~WILLPOWER;
        Assert.assertEquals(32, attributes);
        Assert.assertEquals("100000", Integer.toBinaryString(attributes));
    }


}
