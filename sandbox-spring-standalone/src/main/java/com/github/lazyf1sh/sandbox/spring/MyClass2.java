package com.github.lazyf1sh.sandbox.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyClass2
{
	@Autowired
	@Lazy
	private MyService service;
	
	public void customMethod()
	{
		service.myMethod();
	};
}
