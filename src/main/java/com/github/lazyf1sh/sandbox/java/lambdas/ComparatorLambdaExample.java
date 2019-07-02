package com.github.lazyf1sh.sandbox.java.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaExample
{
	public static void main(String[] args)
	{
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("B", "Z", 20));
		personList.add(new Person("Z", "Z", 25));
		personList.add(new Person("A", "A", 30));

		// Sort with Inner Class
		Collections.sort(personList, new Comparator<Person>()
		{
			public int compare(Person p1, Person p2)
			{
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});

		System.out.println("=== Sorted Asc SurName ===");
		for (Person p : personList)
		{
			System.out.println(p.getGivenName());
		}

		// Use Lambda instead
		// Print Asc
		System.out.println("=== Sorted Asc SurName ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

		for (Person p : personList)
		{
			System.out.println(p.getGivenName());
		}

		// Print Desc
		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList, (p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));

		for (Person p : personList)
		{
			System.out.println(p.getGivenName());
		}

	}
}
