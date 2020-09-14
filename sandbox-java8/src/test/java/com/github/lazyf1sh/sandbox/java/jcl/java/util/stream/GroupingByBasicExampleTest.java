package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * @author Ivan Kopylov
 */
public class GroupingByBasicExampleTest
{
    @Test
    public void run()
    {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        Map<Boolean, List<Integer>> collect = ints.stream().collect(Collectors.groupingBy(integer -> integer > 1));
        assertTrue(collect.get(true).get(1) == 3);
    }

}
