package com.github.lazyf1sh.sandbox.java.exercises.codingbat.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class SumFirstPrimeNumbers
{
    private static List<Integer> foundNumbers = new ArrayList<>();

    public static void main(String[] args)
    {
        int sum = 5;
        int primeNr = 0;
        for (int i = 2; primeNr < 98; i++)
        {
            if (isNumberPrime(i))
            {
                foundNumbers.add(i);
                sum = sum + i;
                primeNr++;
            }
        }
        System.out.println(sum);
    }

    public static boolean isNumberPrime(int number)
    {
        if (number % 2 == 0 || number % 3 == 0)
        {
            return false;
        }

        for (Integer found : foundNumbers)
        {
            if (number % found == 0)
            {

                return false;
            }
        }
        return true;
    }
}
