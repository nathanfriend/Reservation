/* Flight.java
 * Developer: Nathan Friend
 */
package org.nathanfriend.reservations;

public class Flight {
	
	//fields
	private String departureCity;
	private String arrivalCity;
	private int flightNumber;

	//constructor
	public Flight() {
		departureCity = "Unknown Departure City";
		arrivalCity = "Unknown Arrival City";
		flightNumber = 100;
	}
	
	public Flight(int flightNumber, String departureCity, String arrivalCity) {
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}


	//getters and setters
	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String toString() {
		return "Flight: "+ this.getFlightNumber()+" "+
				this.getDepartureCity()+" - "+this.getArrivalCity();
	}

}
