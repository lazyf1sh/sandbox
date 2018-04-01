package lazyf1sh.com.github.sandbox.java.concurrency;

public class Main
{

	public static void main(String[] args)
	{
		new Thread()
		{

			@Override
			public void run()
			{
				println();
			}

			private void println()
			{
				System.out.println(getName());
			}

		}.start();

	}
}