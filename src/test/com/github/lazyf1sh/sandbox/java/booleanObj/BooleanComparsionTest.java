package com.github.lazyf1sh.sandbox.java.booleanObj;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ivan Kopylov
 */
public class BooleanComparsionTest {

    @Test
    public void booleanTest() {

        assertSame(false, Boolean.FALSE == new Boolean(false));
        assertSame(false, Boolean.TRUE == new Boolean(true));
        assertSame(false, Boolean.FALSE == new Boolean(true));
        assertSame(false, Boolean.TRUE == new Boolean(false));

        assertSame(false, Boolean.TRUE.equals(false));
        assertSame(true, Boolean.TRUE.equals(true));



    }
}