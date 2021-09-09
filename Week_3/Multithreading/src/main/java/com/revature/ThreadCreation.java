package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		// Two main ways to create threads
		//1. implement runnable interface and pass it to a new Thread object
		//2. Extend Thread class, and create an object of that class.
		
		Thread t1 = new NewThread();
		t1.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		//this belong to the Main Thread
		System.out.println("Hello from the Main thread! It's name is "+Thread.currentThread().getName());
		
		//2nd way to create a thread (anon class ... lambda to provide the functionality of the run() method
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("We are now in thread "+Thread.currentThread().getName());
				
			}
			
		});
		
		Thread t3 = new Thread(()->System.out.println("Running from Lambda Thread"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.setName("Thread B");
		t2.start();
		
		/**
		 * Thread states:
		 * 
		 * -New
		 * -Runnable (its run() method had been implemented
		 * -Running
		 * -Non-Runnable (Blocked)
		 * -Terminated
		 */

	}
	private static class NewThread extends Thread {

		public void run() {
			
			System.out.println("Hello from "+this.getName());
			
		}
		
		
	}

}

