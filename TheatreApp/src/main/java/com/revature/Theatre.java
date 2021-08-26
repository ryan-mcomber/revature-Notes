package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName; // we will initialize it inside of the constructor
	private List<Seat> seats = new ArrayList<>();
	
	/**
	 * 
	 * When do you an ArrayList over a LinkedList and vice versa
	 * 
	 * ArrayList:
	 * best Searching: is done in O(1) constant time
	 * Worst for Inserting (and deleting): done in O(n) linear time
	 * 
	 * LinkedList:
	 * best for INSERTING/DELETING: O(1) constant time (because LinkedList consists of nodes that addresses)
	 * Worst for: Searching sometime O(1) other times more complex...
	 */
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for (char row = 'A'; row <= lastRow; row++) {
			
			// nested for loop for each row, to make seats for each row 
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				
				seats.add(seat);
			}
			
			
		}
		
		
	}
	
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public void getSeats() {
		for (Seat seat: seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	//I'd like to reserve seat G07
	//BRUTE FORCE ALGORITHM - I will check every single seat to check if it's the one I want to reserve
	public boolean reserveSeat(String seatNumber) { //someone could enter a non existent seat number
		
		Seat requestedSeat = null;
		for (Seat seat: seats) {
			
			System.out.println(".");
			
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat =seat;
				break;
			}
			
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat "+seatNumber);
			return false;
		}
		return requestedSeat.reserve();
		
	}
	
	// Binary Reserve Seat Algorithm
	public boolean reserveSeatBinary(String seatNumber) {
		
		int low = 0;
		int high = seats.size();
		
		while(low<high) {
			
			System.out.println(".");
			
			//select the middle value
			int mid = (low+high)/2;
			
			// use the middle value to capture the middle seat of the row
			Seat midVal = seats.get(mid); //get is a method
			
			//we have to check is the seatNumber pass through greater than or less than the midVal?
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			//0 if equal, -1 if less than, 1 if greater than
			if(cmp <0) {
				low = mid+1;
			} else if (cmp>0) {
				high = mid -1;
			} else {
				return seats.get(mid).reserve();
			}
			
		}
		
		System.out.println("There is no seat "+seatNumber);
		return false;
	}

	//this is a nested class
	/*
	 * Comparable is a special interface that allows us to define the order of a user-defined class
	 * 
	 *  
	 */
	
	private class Seat implements Comparable<Seat>{ //Comparable is an interface we use to define order within a user-created class
		
		private final String seatNumber; // A11 - G11
		private boolean reserved = false;
		
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserve() {
			if(!this.reserved) {
				this.reserved = true;
				
				System.out.println("Reservation of seat "+seatNumber+" confirmed.");
				
				return true;
			} else {
				return false;
			}
		}

		//this is how we define if a seat is greater than or less than another
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
		
		
		
	}
	

}
