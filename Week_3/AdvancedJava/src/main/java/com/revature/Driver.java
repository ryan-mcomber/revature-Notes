package com.revature;

public class Driver {

	public static void main(String[] args) {
		
		//1 way to create a thread is by passing through a runnable object
		Thread classyThread = new Thread(new MyThread());

		classyThread.start();
		
		//Create a thread with an anonymous class
		Thread anonThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Running from a thread created with an anonymous class!");
				
			}
			
		});
		
		anonThread.start();
		
		// Create a thread with a lambda (introduced in Java 8 for code readability)
		Thread lambdaThread = new Thread(() -> System.out.println("Running from the lambda Thread!"));
		lambdaThread.start();
		
		new Thread(() ->{
			System.out.println("Printing from a multi");
			System.out.println("line");
			System.out.println("thread created with a lambda!");
		}).start();
		
		System.out.println("End of main method and thread");
	}

}
 // 1st way to create a thread is to create a class that implements Runnable Interface
class MyThread implements Runnable {

	@Override
	public void run() {
		
		int sum = UtilityMethods.add(10,90);
		
		System.out.println("MyThread is running!");
		
		System.out.println("Result of sum method = "+sum);
		
	}
	
}

class UtilityMethods {
	public static int add(int x, int y) {
		return x+y;
	}
}
