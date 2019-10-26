package com.github.lazyf1sh.sandbox.java.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * https://codingbat.com/prob/p137188
 *
 * @author Ivan Kopylov
 */
public class makeLast
{
    public static int[] makeLast(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums)
        {
            list.add(i);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size() * 2 - 1; i++)
        {
            result.add(0);
        }

        result.add(list.get(list.size() - 1));

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
        {
            resultArr[i] = result.get(i);

        }
        return resultArr;
    }
}
