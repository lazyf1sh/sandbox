package com.github.lazyf1sh.sandbox.java.exercises;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class mirrorEnds
{

    @Test
    public void mirrorEnds()
    {

        String[] data = {"abXYZba", "abca", "aba"};
        for (int i = 0; i < data.length; i++)
        {
            String result = get(data[i]);
            System.out.println(result);
        }


    }


    public String get(String string)
    {

        String result = "";

        int length = string.length();
        for (int i = 0; i < length; i++)
        {
            if (string.charAt(i) == string.charAt(length - i - 1))
            {
                result += string.charAt(i);
            }
            else
            {
                return result;
            }
        }
        return result;

    }
}
