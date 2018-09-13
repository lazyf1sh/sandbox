package com.github.lazyf1sh.sandbox.java.patterns.decorator;

public class Main
{
	// example from
	// https://en.wikipedia.org/wiki/Decorator_pattern
	public static void main(String[] args)
	{
		Window decoratedWindow = new HorizontalScrollbarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
		System.out.println(decoratedWindow.getDescription());
	}
}
