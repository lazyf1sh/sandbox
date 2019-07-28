package com.github.lazyf1sh.sandbox.gun.right.hand.javaIsAlwaysPassByValue;

/**
 * @author Ivan Kopylov
 */
public class Main
{
	public static void main(String[] args)
	{
		//The Java Spec says that everything in Java is pass-by-value. 
		//There is no such thing as "pass-by-reference" in Java.
		
		//The thing is that the value of an object is a link to object
		//
		
		;

		
		Dog aDog = new Dog("Max");
		foo(aDog);
		// aDog variable is still pointing to the "Max" dog 
		aDog.getName().equals("Max"); // true, java passes by value
		aDog.getName().equals("Fifi"); // false
	}
	
	public static void foo(Dog d) {
	    d.getName().equals("Max"); // true
	    // change d inside of foo() to point to a new Dog instance "Fifi"
	    d = new Dog("Fifi");
	    d.getName().equals("Fifi"); // true
	}
}
