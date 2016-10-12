package org.nathanfriend.reservations;
import java.time.LocalDate;

public class Ticket {
	//fields
	private 	LocalDate departureDate;
	private 	Passenger passenger;
	private 	Flight flight;
	private 	Seat seat;
	
	//constructors
	public Ticket () {
		departureDate = LocalDate.now();
	}

	//getters and setters
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	//To String
	public String toString() {
		return "Departure Date: " + this.getDepartureDate() + 
			   "\r\nPassenger: " + this.getPassenger().getName() +
			   "\r\nFlight: " + this.getFlight().getFlightNumber() +
			   "\r\nDeparture City: "+this.getFlight().getDepartureCity() +
			   "\r\nArrival City "+this.getFlight().getArrivalCity() +
			   "\r\nSeat: " + this.getSeat().getSeatNumber();
	}
	


}