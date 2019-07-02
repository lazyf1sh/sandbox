package com.github.lazyf1sh.sandbox.java.java8.genericmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Purpose of this example: to show syntax of java8 generic methods
 * Reader experience: need to know generics
 * Complexity: basic
 */
public class GenericMethodExample
{
    static <T> void fromArrayToCollection(T[] a, Collection<T> c)
    {
        for (T o : a)
        {
            c.add(o); // Correct
        }
    }

    public static void main(String[] args)
    {
        String[] strings = new String[10];
        List list = new ArrayList();
        fromArrayToCollection(strings, list);
    }
}
