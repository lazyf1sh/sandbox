package com.github.lazyf1sh.sandbox.java.java8.streams;

import java.util.stream.Stream;

public class StreamsIntoduction
{

	public static void main(String[] args)
	{
		orderOfOperations();
	}

	/**
	 * order of operation matters demonstration
	 */
	public static void orderOfOperations()
	{
		Stream.of("1", "22", "333").map(s -> s + "q").filter(s -> s.length() > 1 ).forEach(s -> System.out.println(s));
		System.out.println("----");
		Stream.of("1", "22", "333").filter(s -> s.length() > 1 ).map(s -> s + "q").forEach(s -> System.out.println(s));
	}

}
