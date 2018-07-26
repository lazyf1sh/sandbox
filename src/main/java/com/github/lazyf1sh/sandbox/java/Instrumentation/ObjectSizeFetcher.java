package com.github.lazyf1sh.sandbox.java.Instrumentation;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher
{
	private static Instrumentation instrumentation;

	public static void premain(String args, Instrumentation inst)
	{
		instrumentation = inst;
	}

	public static void agentmain(String agentArgs, Instrumentation inst)
	{
		instrumentation = inst;
	}

	public static long getObjectSize(Object o)
	{
		if (instrumentation == null)
		{
			throw new IllegalStateException("Agent not initialized.");
		}
		return instrumentation.getObjectSize(o);
	}

	public static void main(String[] args)
	{
		System.out.println(ObjectSizeFetcher.getObjectSize(new Object()));
	}
}