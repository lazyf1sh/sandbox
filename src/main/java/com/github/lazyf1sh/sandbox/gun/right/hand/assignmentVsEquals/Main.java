package com.github.lazyf1sh.sandbox.gun.right.hand.assignmentVsEquals;
//import java.awt.right.foot.*;
//import java.awt.gun.right.hand.*

public class Main
{
	public static void main(String[] args)
	{
		boolean x = true;
		boolean y = true;
		while (x = y)// should be x == y
		{
			System.out.println("2");
			System.out.println(x);
		}
		System.out.println("1");
	}
}
