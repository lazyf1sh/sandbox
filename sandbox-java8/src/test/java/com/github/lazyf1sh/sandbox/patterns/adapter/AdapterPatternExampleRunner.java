package com.github.lazyf1sh.sandbox.patterns.adapter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Adapter is converter.
 */
public class AdapterPatternExampleRunner
{
    @Test
    public void run()
    {
        Indicator celsius = new CelsiusScaleThermometer();
        IndicatorAdapter indicatorAdapter = new IndicatorAdapterImpl(celsius);

        Assert.assertEquals(68.0, indicatorAdapter.getTemperature(), 0.0);
    }
}
