package com.github.lazyf1sh.sandbox.java.exercises.solutions;

public class countYZ
{
    public static int countYZ(String str)
    {
        int result = 0;
        String[] words = str.split("[^A-Za-z]");
        for (String word : words)
        {
            if (word.length() > 0)
            {
                if (word.charAt(word.length() - 1) == 'z' || word.charAt(word.length() - 1) == 'Z')
                {
                    result++;
                }
                if (word.charAt(word.length() - 1) == 'y' || word.charAt(word.length() - 1) == 'Y')
                {
                    result++;
                }
            }

        }
        return result;
    }
}
