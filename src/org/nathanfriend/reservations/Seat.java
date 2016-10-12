package org.nathanfriend.reservations;

public class Seat {

	private int seatNumber;
	
	//Constructors
	public Seat() {
		setSeatNumber(0);
	}
	
	public Seat(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getSeatNumber() {
		return this.seatNumber ;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public String toString() {
		return "Seat: "+ this.getSeatNumber();
	}

}
