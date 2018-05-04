package com.github.lazyf1sh.sandbox.java.stringFormat;

import java.text.MessageFormat;

public class StringFormat
{
	public static void main(String[] args)
	{
		System.out.println(MessageFormat.format("{0}", "123"));
		System.out.println(String.format("%s", "321"));
	}
}
