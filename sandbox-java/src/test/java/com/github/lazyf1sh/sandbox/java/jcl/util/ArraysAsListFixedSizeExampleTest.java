package com.github.lazyf1sh.sandbox.java.jcl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class ArraysAsListFixedSizeExampleTest
{
    @Test(expected = UnsupportedOperationException.class)
    public void Arrays_asList_immutable()
    {
        List<String> immutableList = Arrays.asList("1", "2");
        immutableList.add("3");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void Collections_singletonList_immutability()
    {
        List<String> immutableList = Collections.singletonList("a");
        immutableList.add("b");
    }

    @Test
    public void Arrays_asList_make_mutable()
    {
        List<String> immutableList = Arrays.asList("1", "2");
        List<String> mutableList = new ArrayList<>(immutableList);
        mutableList.add("3");
        Assert.assertEquals("3", mutableList.get(2));
    }

}
