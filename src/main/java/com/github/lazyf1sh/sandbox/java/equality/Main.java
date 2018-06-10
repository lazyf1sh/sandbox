package com.github.lazyf1sh.sandbox.java.equality;

import java.util.Date;

public class Main
{
	public static void main(String[] args)
	{
		Foo f = new Foo();
		boolean b = f.equals(null);

		Date d = new Date();
		d.equals(null);

		int i = 0;
	}

}
