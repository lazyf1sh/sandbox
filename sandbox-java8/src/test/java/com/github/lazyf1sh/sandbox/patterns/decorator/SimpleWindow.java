package com.github.lazyf1sh.sandbox.patterns.decorator;

//Implementation of a simple Window without any scrollbars
class SimpleWindow implements Window
{
    public void draw()
    {
        // draw window
    }

    public String getDescription()
    {
        return "simple window";
    }
}