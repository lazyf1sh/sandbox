package com.github.lazyf1sh.sandbox.java.equality;

import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class Main
{
	public static void main(String[] args)
	{
		Foo f = new Foo();
		boolean b = f.equals(null);
		System.out.println(b);
		Date d = new Date();
		d.equals(null);

		System.out.println("");
	}

}
