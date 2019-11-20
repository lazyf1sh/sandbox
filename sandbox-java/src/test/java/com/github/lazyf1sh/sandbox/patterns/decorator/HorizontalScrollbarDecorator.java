package com.github.lazyf1sh.sandbox.patterns.decorator;

/**
 * @author Ivan Kopylov
 */
class HorizontalScrollbarDecorator extends WindowDecorator
{

	public HorizontalScrollbarDecorator(Window windowToBeDecorated)
	{
		super(windowToBeDecorated);
	}

	@Override
	public void draw()
	{
		super.draw();
		drawHorizontalScrollbar();
	}

	private void drawHorizontalScrollbar()
	{
		// draw the horizontal scrollbar
	}

	@Override
	public String getDescription()
	{
		return super.getDescription() + ", including horizontal scrollbars";
	}

}
