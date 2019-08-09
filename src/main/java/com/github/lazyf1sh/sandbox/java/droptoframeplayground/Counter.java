package com.github.lazyf1sh.sandbox.java.droptoframeplayground;

/**
 * @author Ivan Kopylov
 */
public class Counter
{
	private int q = 0;

	public void count()
	{
		for (int i = 0; i < 10; i++)
		{
			q += i;
		}
		System.out.println(q); //place break point here and the use "drop to frame" menu selection in the Eclipse
	};
}
