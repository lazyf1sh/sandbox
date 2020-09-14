package com.github.lazyf1sh.sandbox.java.jcl.java.util;

import java.util.function.Supplier;

/**
 * @author Ivan Kopylov
 */
public class ObjectHolder
{
    private static final String FINAL_STR = "initial";
    private static       String STR       = "initial";

    private static final Supplier<String> SUPPLIER = () -> "initial";

    private static final int intFinalValue = 5000;
    private static       int intValue      = 5000;

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

    public static String getValueFromSuplier()
    {
        System.out.println("SUPPLIER STR: " + SUPPLIER.get());
        return SUPPLIER.get();
    }

    public static int getIntFinalValue()
    {
        System.out.println("intFinalValue: " + intFinalValue);
        return intFinalValue;
    }

    public static int getIntValue()
    {
        System.out.println("intValue: " + intValue);
        return intValue;
    }
}
