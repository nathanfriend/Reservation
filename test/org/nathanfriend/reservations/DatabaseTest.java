package org.nathanfriend.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDatabase() {
		Database testDB = new Database();
		assertEquals(0, testDB.getSeats().size());
		assertEquals(0, testDB.getPassengers().size());
		assertEquals(0, testDB.getFlights().size());
		assertEquals(0, testDB.getTickets().size());
	}
	
	@Test
	public void testAddSeat() {
		Database testDB2 = new Database();
		testDB2.addSeat(2);
		assertEquals(1,testDB2.getSeats().size());
		assertEquals(2, testDB2.getSeats().get(0).getSeatNumber());
	}

	
	@Test
	public void testAddFlight(){
		Database testDB5 = new Database();
		testDB5.addFlight(201,"Dover","France");
		assertEquals(1, testDB5.getFlights().size());
		assertEquals(201,testDB5.getFlights().get(0).getFlightNumber());
		assertEquals("Dover",testDB5.getFlights().get(0).getDepartureCity());
		assertEquals("France",testDB5.getFlights().get(0).getArrivalCity());
	}
	
	@Test
	public void testAddPassenger(){
		Database testDB4 = new Database();
		testDB4.addPassenger("Nathan Friend");
		assertEquals(1, testDB4.getPassengers().size());
	}
	
	@Test
	public void testAddNewPassenger(){
		Database testDB6 = new Database();
		boolean result1 = testDB6.addPassenger("Nathan Friend");
		assertEquals(false, result1);
		boolean result2 = testDB6.addPassenger("Nathan Friend");
		assertEquals(true, result2);
	}
	
	@Test
	public void testBootstrap() {
		Database testDB7 = new Database();
		testDB7.bootstrap();
		assertEquals(6, testDB7.getSeats().size());
		assertEquals(4, testDB7.getFlights().size());
	}
}






