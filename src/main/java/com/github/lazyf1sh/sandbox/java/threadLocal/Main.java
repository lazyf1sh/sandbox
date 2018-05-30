package com.github.lazyf1sh.sandbox.java.threadLocal;

import java.util.Date;

public class Main
{

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Foo f = new Foo();
		Thread t = Thread.currentThread();//inspect t in debugger
		int i = 0;
	}
}
