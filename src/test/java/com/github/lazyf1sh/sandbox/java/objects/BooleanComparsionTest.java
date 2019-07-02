package com.github.lazyf1sh.sandbox.java.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanComparsionTest
{
    @Test
    public void booleanTest()
    {
        assertSame(false, Boolean.TRUE == new Boolean(true));
        assertSame(false, Boolean.FALSE == new Boolean(false));
        assertSame(false, Boolean.FALSE == new Boolean(true));
        assertSame(false, Boolean.TRUE == new Boolean(false));
        assertSame(false, Boolean.TRUE == Boolean.FALSE);
        assertSame(false, new Boolean(false) == new Boolean(false));

        assertSame(false, Boolean.TRUE.equals(false));
        assertSame(true, Boolean.TRUE.equals(true));
        assertSame(true, Boolean.FALSE.equals(false));
    }
}