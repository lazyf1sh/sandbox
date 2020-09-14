package com.github.lazyf1sh.sandbox.java.mechanics.oop;

import com.github.lazyf1sh.sandbox.domain.Bottle;
import com.github.lazyf1sh.sandbox.domain.Flask;
import org.junit.Assert;
import org.junit.Test;

/**
 * Constructor is a way to set initial value(s) to an object.
 *
 * @author Ivan Kopylov
 */
public class ConsructorExamplesTest
{
    @Test
    public void runBottle()
    {
        Bottle bottle = new Bottle();
        bottle.initializeMyBottleWithMyCustomMethod(500, "Green", "Metal");

        Assert.assertEquals(500, bottle.getMilliliters());
        Assert.assertEquals("Green", bottle.getColor());
        Assert.assertEquals("Metal", bottle.getMaterial());
    }

    @Test
    public void runFlask()
    {
        Flask flask = new Flask(500, "Green", "Metal");

        Assert.assertEquals(500, flask.getMilliliters());
        Assert.assertEquals("Green", flask.getColor());
        Assert.assertEquals("Metal", flask.getMaterial());
    }

    @Test
    public void runFlaskWithSetters()
    {
        Bottle flask = new Bottle();

        flask.setColor("Green");
        flask.setMaterial("Metal");
        flask.setMilliliters(500);

        Assert.assertEquals(500, flask.getMilliliters());
        Assert.assertEquals("Green", flask.getColor());
        Assert.assertEquals("Metal", flask.getMaterial());
    }

}