package com.github.lazyf1sh.sandbox.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyClass
{
	@Autowired
	private MyService service;
	
	public void someMethod() throws InterruptedException
	{
		service.myMethod();
	};
}
