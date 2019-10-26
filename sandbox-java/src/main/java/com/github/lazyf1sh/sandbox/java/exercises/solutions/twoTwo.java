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
    public boolean twoTwo(int[] nums)
    {
        boolean result = true;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == 2 && nums[i - 1] == 2)
            {

            }
        }
        return result;
    }

}
