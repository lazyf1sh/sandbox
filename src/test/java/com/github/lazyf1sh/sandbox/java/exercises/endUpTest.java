package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Assert;
import org.junit.Test;

public class endUpTest {

    @Test
    public void endUp() {
        String result1 = endUp.endUp("test");
        String result2 = endUp.endUp("me");

        Assert.assertEquals("tEST", result1);
        Assert.assertEquals("ME", result2);

        Assert.assertNotEquals("TEST", result1);
        Assert.assertNotEquals("", result1);
        Assert.assertNotEquals("382190id", result1);
        Assert.assertNotEquals("EST", result1);
        Assert.assertNotEquals(null, result1);
    }
}