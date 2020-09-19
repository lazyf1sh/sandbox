package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.threadJoinExample;

/**
 * @author Ivan Kopylov
 */
public class MyRunnable implements Runnable
{
	private String name;
	private Thread thread;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Thread getThread()
	{
		return thread;
	}

	public void setThread(Thread thread)
	{
		this.thread = thread;
	}

	public MyRunnable(String threadName)
	{
		this.name = threadName;
		thread = new Thread(this, threadName);
		thread.start();
	}

	public void run()
	{
		try
		{
			Thread.sleep(5000);
			System.out.println(this.name);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
