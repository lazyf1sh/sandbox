package com.github.lazyf1sh.sandbox.java;

import java.math.BigDecimal;

public class Sum
{
	public static void main(String[] args)
	{
		float f = 599.99f;
		System.out.printf("float %s%n", new BigDecimal(f).setScale(6, BigDecimal.ROUND_DOWN));
		double d = 599.99d;
		System.out.printf("double %s%n", new BigDecimal(d).setScale(15, BigDecimal.ROUND_DOWN));
	}
}
