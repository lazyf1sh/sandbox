package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Source: https://codingbat.com/prob/p196441 <br/>
 * Solution: https://gist.github.com/lazyf1sh/f73796ebc7bf28df161df10bb7592b35
 */
public class everyNthTest {

    @Test
    public void everyNth() {
        String s = everyNth.everyNth("Miracle", 2);

        Assert.assertEquals("Mrce", s);
    }
}