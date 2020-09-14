package com.github.lazyf1sh.sandbox.patterns.decorator;

/**
 * @author Ivan Kopylov
 */
class WindowDecorator implements Window
{
    protected Window windowToBeDecorated;

    public WindowDecorator(Window windowToBeDecorated)
    {
        super();
        this.windowToBeDecorated = windowToBeDecorated;
    }

    public void draw()
    {
        windowToBeDecorated.draw(); // delegation
    }

    public String getDescription()
    {
        return windowToBeDecorated.getDescription(); // delegation
    }
}
