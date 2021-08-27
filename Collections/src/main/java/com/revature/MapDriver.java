package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	public static void main(String[] args) {
		
		// create a simple HashMap
		
		Map<String, String> languages = new HashMap<String,String>();
		
		// use the .put() method to insert data into a map
		languages.put("Java", "A compliled high-level object oriented, platform independant language");
		languages.put("Python", "an interpreted OOP language.");
		languages.put("JavaScript", "interpreted language, lightweight, runs in browser or Node.js");
		
		/**
		 * The Map interface does NOT extend Iterable.
		 * 
		 * - You cannot have duplicate keys!!!!
		 * - you can have duplicate values.
		 * 
		 */
		
		//this would just replace the previous value
		languages.put("JavaScript", "NOT Java....!");
		
		System.out.println("I like to program in Java which is "+languages.get("Java"));
		
		// How to iterate over a Map?
		
		// want all keys
		
		for(String key: languages.keySet()) {
			
			System.out.println("The key is "+key);
		}
		
		//how do we iterate over both the keys and the value within that Map?
		for (Map.Entry<String,String> entry : languages.entrySet()) {
			
			System.out.println(entry);
		}

	}

}
