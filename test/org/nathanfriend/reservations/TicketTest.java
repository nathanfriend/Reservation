package org.nathanfriend.reservations;
import java.time.LocalDate;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testSetPassenger() {
		Ticket testTicket1 = new Ticket();
		Passenger testPassenger1 = new Passenger("Nathan Friend");
		testTicket1.setPassenger(testPassenger1);
		assertEquals("Nathan Friend", testTicket1.getPassenger().getName());
	}
	
	@Test
	public void testSetDepartureDate() {
		Ticket testTicket2 = new Ticket();
		testTicket2.setDepartureDate(LocalDate.now());
		assertEquals(LocalDate.now(),testTicket2.getDepartureDate());
	};
	
	@Test
	public void testSetFLight() {
		Ticket testTicket3 = new Ticket();
		Flight testFlight1 = new Flight(300, "France", "Dover");
		testTicket3.setFlight(testFlight1);
		assertEquals(300,testTicket3.getFlight().getFlightNumber());
	}

	@Test
	public void testSetSeat() {
		Ticket testTicket4 = new Ticket();
		Seat testSeat1 = new Seat(2);
		testTicket4.setSeat(testSeat1);
		assertEquals(2,testSeat1.getSeatNumber());
	}
}

