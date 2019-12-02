package com.github.lazyf1sh.sandbox.patterns.adapter;

public class IndicatorAdapterImpl implements IndicatorAdapter
{

    private Indicator indicator;

    public IndicatorAdapterImpl(Indicator indicator)
    {
        this.indicator = indicator;
    }

    @Override
    public double getTemperature()
    {
        double temperature = indicator.getTemperature();
        return convert(temperature);
    }

    private double convert(double temperature)
    {
        return temperature * 1.8 + 32;
    }
}
