package com.github.lazyf1sh.sandbox.java;

import java.io.UnsupportedEncodingException;

public class GetBytes
{
	public static void main(String[] args)
	{
		try
		{
			byte[] bytes = "🞺".getBytes("windows-1251");
			int i = 0;
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String s = new String(new byte[] {-21, -92, -128});
		System.out.println(s);
	}
}
