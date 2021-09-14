package com.revature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.something.Person;

// this is a dynamic proxy design pattern
// a proxy is an "add-on" to a class, that allows to intercept method invocation and modify runtime behavior
public class PersonInvocationHandler implements InvocationHandler{
	
	//declare the interface that we're overriding
	private Person person;
	
	// a constructor for the proxy object
	public PersonInvocationHandler(Person person) {
		super();
		this.person = person;
	}

	// Using this method we can modify the behavior of a class using reflection
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Hello!");
		return null;
	}


}
