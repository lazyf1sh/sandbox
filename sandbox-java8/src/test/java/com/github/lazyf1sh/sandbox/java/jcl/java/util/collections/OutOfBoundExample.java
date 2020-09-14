package com.github.lazyf1sh.sandbox.java.jcl.java.util.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OutOfBoundExample
{
    @Test(expected = IndexOutOfBoundsException.class)
    public void run()
    {
        List<String> l = new ArrayList<>();
        l.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void run2()
    {
        List<String> l = new ArrayList<>();
        l.get(500);
    }
}
