package lazyf1sh.com.github.sandbox.java.concurrency;

public class Main
{

	public static void main(String[] args) throws InterruptedException
	{

		for (int i = 0; i < 10000; i++)
		{
			new Thread()
			{
				@Override
				public void run()
				{
					for (int i = 0; i < 1000000000; i++)
					{
						int j = i * i;
					}
					println();
					try
					{
						sleep(5000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				private void println()
				{
					System.out.println(getName());
				}

			}.start();
		}

	}
}