package com.github.lazyf1sh.sandbox.java.patterns.decorator;

public class WindowDecorator implements Window
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
