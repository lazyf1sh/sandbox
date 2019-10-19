package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Assert;
import org.junit.Test;

public class everyNthTest {

    @Test
    public void everyNth() {
        String s = everyNth.everyNth("Miracle", 2);

        Assert.assertEquals("Mrce", s);
    }
}