package com.github.lazyf1sh.sandbox.algorithms;

/**
 * type: Divide and conquer
 * https://i.imgur.com/Dx10nAG.png
 * From scratch approach: this implementation is written just to practice, not to read it or use as reference
 */

public class MergeSortAttemptOne
{



























































































    public int[] sort(int[] array)
    {
        return mergeSort(array);
    }

    private static int[] mergeSort(int[] array)
    {
        if (array.length < 2)
        {
            return array;
        }

        int[][] lr = split(array);
        int[] left = lr[0];
        int[] right = lr[1];

        left = mergeSort(left);
        right = mergeSort(right);

        return dasda(left, right);
    }

    private static int[][] split(int[] array)
    {
        int[][] result = new int[2][array.length / 2];

        for (int i = 0; i < array.length / 2; i++)
        {
            result[0][i] = array[i];
        }
        for (int j = 0, i = array.length / 2; i < array.length; i++, j++)
        {
            result[1][j] = array[i];
        }

        return result;
    }

    private static int[] dasda(int[] left, int[] right)
    {
        int[] result = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] < right[j])
            {
                result[k] = left[i];
                i++;
            }
            else
            {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length)
        {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < left.length)
        {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

}
