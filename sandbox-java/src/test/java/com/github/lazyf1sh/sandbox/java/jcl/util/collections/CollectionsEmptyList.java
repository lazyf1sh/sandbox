package com.github.lazyf1sh.sandbox.java.jcl.util.collections;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class CollectionsEmptyList
{
    @Test(expected = UnsupportedOperationException.class)
    public void run()
    {
        List<Object> objects = Collections.emptyList();
        objects.add("dsa");
    }
}
