package com.github.lazyf1sh.sandbox.java.booleanEvaluationOrder;

public class Main
{
	public static void main(String[] args)
	{
		boolean one = method1() && method2() || method3() && method4();
	}

	private static boolean method1()
	{
		System.out.println("method1");
		return true;
	}

	private static boolean method2()
	{
		System.out.println("method2");
		return true;
	}

	private static boolean method3()
	{
		System.out.println("method3");
		return true;
	}

	private static boolean method4()
	{
		System.out.println("method4");
		return true;
	}
}
