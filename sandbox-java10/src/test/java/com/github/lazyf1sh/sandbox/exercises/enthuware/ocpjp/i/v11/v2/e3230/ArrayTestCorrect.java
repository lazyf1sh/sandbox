package com.github.lazyf1sh.sandbox.exercises.enthuware.ocpjp.i.v11.v2.e3230;

public class ArrayTestCorrect
{
    public static void main(String[] args)
    {
        var ia = new int[][]{{1, 2}, null};
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.println(ia[i][j]);
            }
        }
    }

}
