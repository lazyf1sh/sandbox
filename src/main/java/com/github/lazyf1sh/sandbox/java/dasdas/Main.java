package com.github.lazyf1sh.sandbox.java.dasdas;

public class Main
{

	public static String VARIABLE = init();

	public static void main(String[] args)
	{
		Another a = new Another();
		System.out.println("123");
	}

	private static String init()
	{
		//inits only once on class loading
		return "1";
	}

}
