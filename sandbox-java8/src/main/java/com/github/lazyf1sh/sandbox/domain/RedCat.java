package com.github.lazyf1sh.sandbox.domain;

/**
 * @author Ivan Kopylov
 */
public class RedCat extends Cat
{
    private String name;

    public RedCat(final String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
