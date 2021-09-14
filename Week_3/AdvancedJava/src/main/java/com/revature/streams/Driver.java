package com.revature.streams;

import java.util.Arrays;
import java.util.List;

public class Driver {
	
	/**
	 * Streams - Stream API was introduced in Java 8.
	 * it is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection! It is a sequence of object references that support various 
	 * methods that can be piplined to produce the desired result.
	 * 
	 * We use Streams to take input from Collections, Arrays, or I/O channels.
	 */
	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				"D40","D46",
				"B12","B6",
				"G53","G49","G15","g64",
				"I13","I22","I29",
				"O71"
				);
		
		// Let's print all of the Bingo Numbers in column G
		
		//tradition way we've been operating on collections
		bingoNums.forEach(n -> {
			if (n.toUpperCase().startsWith("G")) {
				System.out.println(n);
			}
		});	
		
		System.out.println("=============================================");
		
		bingoNums.stream().map(String::toUpperCase) //map applies a given function to each element within data structure
		// here we are referencing the method from a specific class that we want to perform on each element within the list
		
		// Method referencing  Class::Method
		// String::toUpperCase
		.filter(s->s.startsWith("G"))
		.sorted()
		.forEach(System.out::println);
		
	}
}
