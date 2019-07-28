package com.github.lazyf1sh.sandbox.java.java8.streams.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.multithreading.synchronizedkeyword.Counter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ivan Kopylov
 */
public class GroupingByBasicExampleTest
{
    @Test
    public void run() throws InterruptedException
    {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        Map<Boolean, List<Integer>> collect = ints.stream().collect(Collectors.groupingBy(integer -> integer > 1));
        assertTrue(collect.get(true).get(1) == 3);
    }

}
