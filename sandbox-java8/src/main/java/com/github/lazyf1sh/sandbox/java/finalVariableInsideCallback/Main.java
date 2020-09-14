package com.github.lazyf1sh.sandbox.java.finalVariableInsideCallback;

/**
 * @author Ivan Kopylov
 */
public class Main
{
	public static void main(String[] args)
	{
		//errors: cannot access a non-final variable inside an inner class defined in a different method

		final String str = "";//why this have to be final?
		new One()
		{
			//With anonymous classes, you are actually declaring a "nameless" nested class q
			@Override
			public void someMethod()
			{
				
				System.out.println(str);
			}
		};
		
		/*
		 * For nested classes, the compiler generates a new standalone public class
		 * with a constructor that will take all the variables it uses as arguments
		 */

		/*
		public void someMethod() {
		    String shared = "hello"; 
		    new EnclosingClass$1(shared).start();

		    // change the reference 'shared' points to, with a new value
		    shared = "other hello"; 
		    System.out.println(shared);
		}
		*/
		
		//str will be destroyed after method end
	}
}
