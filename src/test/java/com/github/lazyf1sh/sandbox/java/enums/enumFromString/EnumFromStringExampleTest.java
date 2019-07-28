package com.github.lazyf1sh.sandbox.java.enums.enumFromString;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ivan Kopylov
 */
public class EnumFromStringExampleTest
{
    @Test
    public void testGoodCase()
    {
        MyEnum myEnum = MyEnum.valueOf("MY_ENUM_VALUE");
        assertEquals(myEnum, MyEnum.MY_ENUM_VALUE);
    }

    @Test
    public void testBadCase()
    {
        MyEnum myEnum = MyEnum.valueOf("MY_ENUM_VALUE__________________");

    }
}