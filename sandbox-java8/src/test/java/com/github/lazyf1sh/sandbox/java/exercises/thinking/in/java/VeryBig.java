package com.github.lazyf1sh.sandbox.java.exercises.thinking.in.java;

/**
 * @author Ivan Kopylov
 */
public class VeryBig
{
    private static final int    SIZE = 10000;
    private              long[] la   = new long[SIZE];
    private              String id;

    public VeryBig(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return id;
    }

    @Override
    protected void finalize()
    {
        System.out.println("Finalizing " + id);
    }
}
