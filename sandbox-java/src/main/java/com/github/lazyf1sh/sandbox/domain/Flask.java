package com.github.lazyf1sh.sandbox.domain;

/**
 * @author Ivan Kopylov
 */
public class Flask
{
    private int    milliliters;
    private String color;
    private String material;

    /**
     * Constructor
     * 1. Mandatory method - guarantess that object is initialized to work with.
     * 2. Same as the class name.
     * 3. Allocates memory.
     * 4. No return arg.
     */
    public Flask(final int milliliters, final String color, final String material)
    {
        this.milliliters = milliliters;
        this.color = color;
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
}
