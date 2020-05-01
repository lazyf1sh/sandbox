package com.github.lazyf1sh.sandbox.patterns.decorator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Decorator Pattern Example.
 *
 * @author Ivan Kopylov
 */
public class DecoratorPatternExample
{
    // example from
    // https://en.wikipedia.org/wiki/Decorator_pattern
    @Test
    public void main()
    {
        Window decoratedWindow = new HorizontalScrollbarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
        System.out.println(decoratedWindow.getDescription());
        Assert.assertEquals("simple window, including vertical scrollbars, including horizontal scrollbars", decoratedWindow.getDescription());
    }
}
