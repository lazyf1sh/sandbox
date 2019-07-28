package com.github.lazyf1sh.sandbox.java.patterns.decorator;

/**
 * @author Ivan Kopylov
 */
public class VerticalScrollBarDecorator extends WindowDecorator
{
	public VerticalScrollBarDecorator(Window windowToBeDecorated)
	{
		super(windowToBeDecorated);
	}

	@Override
	public void draw()
	{
		super.draw();
		drawVerticalScrollbar();
	}

	private void drawVerticalScrollbar()
	{
		// draw the vertical scroll bar
	}

	@Override
	public String getDescription()
	{
		return super.getDescription() + ", including vertical scrollbars";
	}

}
