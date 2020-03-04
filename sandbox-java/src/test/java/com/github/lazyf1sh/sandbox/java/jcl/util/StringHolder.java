package com.github.lazyf1sh.sandbox.java.jcl.util;

/**
 * @author Ivan Kopylov
 */
public class StringHolder
{
    private static final String FINAL_STR = "initial";
    private static String       STR       = "initial";

    public static String getFinalStr()
    {
        System.out.println("FINAL STR: " + FINAL_STR);
        return FINAL_STR;
    }

    public static String getSTR()
    {
        System.out.println("STR: " + STR);
        return STR;
    }
}
