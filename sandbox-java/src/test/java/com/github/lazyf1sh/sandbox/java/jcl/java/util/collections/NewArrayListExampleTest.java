package com.github.lazyf1sh.sandbox.java.jcl.java.util.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NewArrayListExampleTest
{

    @Test
    public void test()
    {
        List<MyObj> list1 = new ArrayList<>();
        list1.add(new MyObj());
        list1.add(new MyObj());
        list1.add(null);

        List<MyObj> list2 = new ArrayList<>(list1);

        Assert.assertTrue(list1.get(0) == list2.get(0));
        Assert.assertTrue(list1.get(1) == list2.get(1));
    }
}
