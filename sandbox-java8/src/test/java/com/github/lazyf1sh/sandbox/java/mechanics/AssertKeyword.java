package com.github.lazyf1sh.sandbox.java.mechanics;

import org.junit.Test;

public class AssertKeyword
{
    @Test(expected = AssertionError.class)
    public void run()
    {
        assert 2 == 1;
    }
}
