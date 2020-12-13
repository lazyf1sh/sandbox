package com.github.lazyf1sh.sandbox.programming.forcycle;

/**
 * enthuware.ocpjp.i.v11.2.963
 * <p>
 * INT1 and INT2 can be any two integers.  Which of the following will produce the same result?
 */
public class CyclesIncrementAndPrint
{
    /**
     * Cycle given in the task description to compare with others.
     *
     * @param int1
     * @param int2
     */
    public static void cycleOne(int int1, int int2)
    {
        for (int i = int1; i < int2; i++)
        {
            System.out.println(i);
        }
    }

    public static void cycleTwo(int int1, int int2)
    {
        for (int i = int1; i < int2; System.out.println(++i))
        {

        }
    }

    public static void cycleTwoOption2(int int1, int int2)
    {
        for (int i = int1; i < int2; System.out.println(i++))
        {

        }
    }

    public static void cycleThree(int int1, int int2)
    {
        for (int i = int1; i++ < int2; System.out.println(i))
        {

        }
    }

    public static void cycleFour(int int1, int int2)
    {
        int i = int1;
        while (i++ < int2)
        {
            System.out.println(i);
        }
    }

    public static void cycleFive(int int1, int int2)
    {
        int i = int1;
        do
        {
            System.out.println(i);
        }
        while (i++ < int2);
    }
}