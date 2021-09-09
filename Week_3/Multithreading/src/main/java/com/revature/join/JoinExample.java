package com.revature.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinExample {

	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(0L,3535L,35435L,3243L,23L,6655L);
		// we will want to calculate the factorials of each of these numbers
		
		//first, we build a data structure to collect some yet-to-be-new threads in
		List<FactorialThread> threads = new ArrayList<>();

		// 1) for each number within the input numbers, pass it to the constructor of a newly
		// instantiated thread, and add it to the thread list
		for(long num: inputNumbers) {
			// we are assigning one factorial thread per input number that needs calculation
			threads.add(new FactorialThread(num));
			
		}
		
		// 2) iterate over all of the factorial threads and start() them
		for (Thread t:threads) {
			t.setDaemon(true);
			t.start(); // this begins race conditions between the factorial threads and the main thread.
		}
		//below if what the MAIN thread is doing
		for (Thread t: threads) {
			t.join(); // this may throw an InterruptedException, so instead we add the throws declaration to the main() method
			// join() is a synchronization method that block the calling thread until the thread it's being called on completes
		}
		
		//3. Check to see the result of the factorial thread (if each thread has finished yet);
		for (int i=0; i<inputNumbers.size();i++) {
			
			FactorialThread factorialThread = threads.get(i); //O(1) retrieval (constant time retrieving from arraylist)
			
			if(factorialThread.isFinished()) {
				System.out.println("Factorial of "+inputNumbers.get(i)+" is "+factorialThread.getresult());
			}else {
				System.out.println("The calculation for "+inputNumbers.get(i)+" is still in progress....");
			}
		}
		
		/*
		 * Here we have a race condition between the main thread and the factorial thread
		 * 
		 * In order to solve this, we must implement the join method so that the main method will WAIT
		 * for the factorial threads to finish computing before checking
		 */
		
	}

}
