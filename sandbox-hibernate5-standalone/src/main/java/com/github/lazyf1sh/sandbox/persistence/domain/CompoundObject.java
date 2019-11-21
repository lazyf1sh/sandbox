package com.github.lazyf1sh.sandbox.persistence.domain;

/**
 * Purpose: TODO .
 *
 * @author Ivan Kopylov
 */
public class CompoundObject
{
    private int a;
    private String b;

    public CompoundObject(final int a, final String b)
    {
        this.a = a;
        this.b = b;
    }

    public int getA()
    {
        return a;
    }

    public void setA(final int a)
    {
        this.a = a;
    }

    public String getB()
    {
        return b;
    }

    public void setB(final String b)
    {
        this.b = b;
    }
}
