package com.github.lazyf1sh.sandbox.spring;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class MyService
{
	private Date myDate = new Date();
	
	public void myMethod()
	{
		System.out.println(myDate);
	};
}
