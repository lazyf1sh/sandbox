package com.github.lazyf1sh.sandbox.java.operatorPrecedence;

/**
 * Java operators evaluation order
 */
public class OperatorPrecedenceExOne
{
    public static void main(String[] args)
    {

        if (one() && two() || three())
        {

        }
    }

    private static boolean one()
    {
        System.out.println("1");
        return true;
    }

    private static boolean two()
    {
        System.out.println("2");
        return true;
    }

    private static boolean three()
    {
        System.out.println("3");
        return false;
    }
}
