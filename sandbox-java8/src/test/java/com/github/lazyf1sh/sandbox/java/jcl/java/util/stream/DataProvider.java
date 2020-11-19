package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ngolubev
 */
public class DataProvider
{

    public static List<ComparableObject> createObjects()
    {
        return new ArrayList<>(Arrays.asList(
                new ComparableObject("str1", new Date(), 4),
                new ComparableObject("str2", new Date(55555555), 3),
                new ComparableObject("str3", new Date(55555555), 6)

        ));
    }public static List<ComparableObject> createObjectsWithNulls()
    {
        return new ArrayList<>(Arrays.asList(null,
                new ComparableObject("str1", new Date(), 4),
                new ComparableObject("str2", new Date(55555555), 3),
                new ComparableObject("str3", new Date(55555555), 6),
                null
        ));
    }

}
