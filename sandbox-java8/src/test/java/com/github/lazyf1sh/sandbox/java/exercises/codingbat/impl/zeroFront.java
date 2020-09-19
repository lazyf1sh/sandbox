package com.github.lazyf1sh.sandbox.java.exercises.codingbat.impl;

import java.util.Arrays;

/**
 * https://codingbat.com/prob/p193753
 * @author Ivan Kopylov
 */
public class zeroFront
{
    public int[] zeroFront(int[] nums)
    {
        int[] result = new int[nums.length];
        int q = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                result[nums.length - q - 1] = nums[i];
                q++;
            }
        }

        return result;
    }

    public int[] zeroFront2(int[] nums)
    {
        int zeroesAmount = 0;
        for(int elem : nums)
        {
            if(elem == 0)
            {
                zeroesAmount++;
            }
        }

        int[] result = new int[nums.length];
        for(int i = zeroesAmount; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                result[i] = nums[i];
            }
        }

        return result;
    }

    public int[] zeroFront3(int[] nums)
    {
        Arrays.sort(nums);
        return nums;
    }

}
