package com.github.lazyf1sh.sandbox.java.mechanics.lambdas;

/*
 * java lambdas
 * 
 * ***
 * 
 * A functional interface is an interface that contains only one abstract method
 * {@link Runnable}, ActionListener, Comparable are some of the examples of functional interfaces
 * functional interface was previously known as a Single Abstract Method type (SAM).
 * 
 * ***
 * 
 * A lambda expression is composed of three parts.
 * Argument List  | Arrow	| 	Token Body
 * (int x, int y) | ->		|	x + y
 * 
 * ***
 * 
 */
public class RunnableLambdaExample
{
	public static void main(String args[])
	{
		Runnable r1 = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("runnable 1");
			}
		};
		
		Runnable r2 = () -> System.out.println("runnable 2");
		r1.run();
		r2.run();
	}
}
