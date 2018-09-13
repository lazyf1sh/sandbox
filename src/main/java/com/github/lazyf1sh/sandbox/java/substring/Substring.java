package com.github.lazyf1sh.sandbox.java.substring;

public class Substring
{
	public static void main(String[] args)
	{
		String s = "0123456789*";
		System.out.println(s.substring(0, 4));
		System.out.println(s.substring(4, 10));
		System.out.println("1" + null);
		
		String umlaut = "Ä";
	 	boolean a = umlaut.equals("Ä");
	 	boolean b = umlaut.equals("\u00c4");
	 	
	 	System.out.println(a);
	 	System.out.println(b);
	}
}
