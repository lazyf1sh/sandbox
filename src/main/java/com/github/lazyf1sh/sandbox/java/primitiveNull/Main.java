package com.github.lazyf1sh.sandbox.java.primitiveNull;

public class Main
{

	public static void main(String[] args)
	{
		byte[] b = new byte[2];
		b[0] = 1;
		b[1] = 2;
		
		System.out.println(b.length);
		
		b = null;
		
		System.out.println(b.length);
	}

}
