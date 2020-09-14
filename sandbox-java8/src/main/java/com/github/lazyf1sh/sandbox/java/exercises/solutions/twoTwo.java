package com.github.lazyf1sh.sandbox.java.exercises.solutions;

/**
 * @author Ivan Kopylov
 * Given an array of ints, return true
 * if every 2 that appears in the array is next to another 2.
 * twoTwo([4, 2, 2, 3]) → true
 * twoTwo([2, 2, 4]) → true
 * twoTwo([2, 2, 4, 2]) → false
 * https://codingbat.com/prob/p102145
 */
public class twoTwo
{
    public static boolean twoTwo(int[] nums)
    {
        if (nums.length == 1 && nums[0] == 2)
        {
            return false;
        }

        if (nums.length < 2)
        {
            return true;
        }

        for (int i = 1; i < nums.length - 1; i++)
        {
            if (nums[i] == 2)
            {
                if (nums[i - 1] != 2 && nums[i + 1] != 2)
                {
                    return false;
                }
            }
        }
        if (nums[nums.length - 1] == 2 && nums[nums.length - 2] != 2)
        {
            return false;
        }
        if (nums[0] == 2 && nums[1] != 2)
        {
            return false;
        }
        return true;
    }

}
