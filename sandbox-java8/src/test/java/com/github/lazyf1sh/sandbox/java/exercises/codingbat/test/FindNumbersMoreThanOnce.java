package com.github.lazyf1sh.sandbox.java.exercises.codingbat.test;

import org.junit.Test;

public class FindNumbersMoreThanOnce
{
    @Test
    public void run()
    {
        int[] array = {5, 8, -1, 8, 13, -500, 1000, 541, -50, 8, -50, -30, -50};

        int[][] ga = new int[array.length][2];

        int lastFilledIndex = 0;
        int lastTakenIndex = 0;

        for (int i = 0; i < array.length; i++)
        {
            boolean found = false;
            for (int k = 0; k < array.length; k++)
            {
                if (array[i] == ga[k][0])
                {
                    ga[k][1]++;
                    found = true;
                }
            }

            if (!found)
            {
                ga[lastFilledIndex][0] = array[lastTakenIndex];
                ga[lastFilledIndex][1]++;
                lastFilledIndex++;
                lastTakenIndex++;
            }
        }


        for (int i = 0; i < ga.length; i++)
        {
            if (ga[i][1] > 1)
            {
                System.out.println(ga[i][0] + " " + ga[i][1]);
            }
        }
    }

}
