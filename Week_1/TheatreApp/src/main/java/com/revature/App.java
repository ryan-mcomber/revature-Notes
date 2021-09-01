package com.revature;

public class App {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Theatre theatre = new Theatre("Ford's Theatre", 8, 12);
		theatre.getSeats();

		// I want to reserve a seat.
		
		//I'll enter the seatNumber, and it must go through a method in the Theatre class to check if it's reserved or not.
		if(theatre.reserveSeatBinary("H12")) { // O(log n) -- logarithmic
			System.out.println("Please pay to reserve this free seat.");
			
		}else {
			System.out.println("The seat is reserved,sorry.");
		}
		
	}

}
