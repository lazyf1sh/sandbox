package com.github.lazyf1sh.sandbox.domain;

/**
 * No constuctor means "default constuctor".
 *
 * @author Ivan Kopylov
 */
public class Bottle
{
    private int    milliliters;
    private String color;
    private String material;

    public void initializeMyBottleWithMyCustomMethod(int milliliters, String color, String material)
    {
        this.milliliters = milliliters;
        this.color = color;
        this.material = material;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(final String color)
    {
        this.color = color;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(final String material)
    {
        this.material = material;
    }

    public int getMilliliters()
    {
        return milliliters;
    }

    public void setMilliliters(final int milliliters)
    {
        this.milliliters = milliliters;
    }
}

