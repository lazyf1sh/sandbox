package com.github.lazyf1sh.sandbox.java.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Foo
{
	/*
	 * This kind of variable differs from it's normal analog in that each thread
	 * that accessed one (via get or set method) has it's own independently initialized copy of the variable
	 * ThreadLocal instances typically private static fields in classes that wish to
	 * associate state with a thread (e.g., user id or transaction id) 
	 */
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>()
	{

		@Override
		protected SimpleDateFormat initialValue()
		{
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	public String formatIt(Date date)
	{
		return formatter.get().format(date);
	}
}
