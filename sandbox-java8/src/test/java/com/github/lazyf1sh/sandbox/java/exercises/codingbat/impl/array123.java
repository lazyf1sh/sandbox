package com.github.lazyf1sh.sandbox.java.exercises.codingbat.impl;

/**
 * https://codingbat.com/prob/p136041
 * @author Ivan Kopylov
 */
public class array123
{
    public static boolean array123(int[] numbers)
    {
        if (numbers.length > 2)
        {
            for (int i = 0; i < numbers.length - 2; i++)
            {
                if (numbers[i] == 1 && numbers[i + 1] == 2 && numbers[i + 2] == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
