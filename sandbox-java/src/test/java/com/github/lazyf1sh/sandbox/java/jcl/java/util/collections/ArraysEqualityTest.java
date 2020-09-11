package com.github.lazyf1sh.sandbox.java.jcl.java.util.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class ArraysEqualityTest
{
    @Test
    public void run()
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");

        Assert.assertTrue(list.equals(list2)); //compared in AbstractList.equals() one by one
    }
}
