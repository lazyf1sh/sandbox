package com.github.lazyf1sh.sandbox.java.jcl.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

public class BooleanObjTest
{
    @Test
    public void run()
    {
        Boolean a = false;
        Boolean b = Boolean.FALSE;

        modifyBoolean(a);
        modifyBoolean(b);

        assertFalse(a);
        assertFalse(b);

    }

    private void modifyBoolean(Boolean value)
    {
        value = true;
        // value.set(true) - no such a built-in method in JCL
    }

    @Test
    public void atomicBoolean()
    {
        AtomicBoolean a = new AtomicBoolean(false);
        modifyAtomicBoolean(a);
        assertTrue(a.get());

    }

    private void modifyAtomicBoolean(AtomicBoolean value)
    {
        value.set(true);
    }
}
