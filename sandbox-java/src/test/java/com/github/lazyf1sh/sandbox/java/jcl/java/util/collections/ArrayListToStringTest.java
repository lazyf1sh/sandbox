package com.github.lazyf1sh.sandbox.java.jcl.java.util.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Kopylov
 */
public class ArrayListToStringTest
{
    @Test
    public void run()
    {
        List<String> list = new ArrayList<>();
        list.add("dsa1");
        list.add("dsa2");
        list.add("dsa3");
        list.add("dsa4");
        String x = list.toString();
        assertEquals("[dsa1, dsa2, dsa3, dsa4]", x);
    }
}
