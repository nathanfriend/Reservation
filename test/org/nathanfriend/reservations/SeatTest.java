package org.nathanfriend.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeatTest {

	@Test
	public void testSeat() {
		Seat testSeat1 = new Seat();
		assertEquals(0,testSeat1.getSeatNumber());
	}

	@Test
	public void testSetSeatNumber() {
		Seat testSeat2 = new Seat();
		testSeat2.setSeatNumber(6);
		assertEquals(6,testSeat2.getSeatNumber());
	}
	
	@Test
	public void testAddSeat(){
		Database testDB2 = new Database();
		testDB2.addSeat(2);
		assertEquals(1, testDB2.getSeats().size());
	}
}
