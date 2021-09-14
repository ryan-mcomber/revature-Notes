package com.revature;

import java.lang.reflect.Proxy;

//we can import classes/methods and interfaces from other project
import com.something.Adult;
import com.something.Person;

public class App {

	public static void main(String[] args) {
		
		Adult a1 = new Adult("Arnold",30,"Innsbruck","Austria");
		
		// I want to modify the method at runtime
		// I can't because it's not my code (it's from an external framework)
		a1.introduce();
		
		/**
		 * Reflection API is used to examine or modify the behavior of classes/method/interfaces at runtime
		 */
		
		// get a ClassLoader from the original object that we want to create a proxy fo
		ClassLoader a1ClassLoader = a1.getClass().getClassLoader();
		
		// capture all the interfaces that the original object implements
		Class[] interfaces = a1.getClass().getInterfaces();
		
		// Create a proxy for our Adult object
		Person proxyA1 = (Person) Proxy.newProxyInstance(a1ClassLoader, interfaces, new PersonInvocationHandler(a1));
		
		proxyA1.introduce();

	}

}
