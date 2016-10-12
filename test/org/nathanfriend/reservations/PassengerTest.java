package org.nathanfriend.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerTest {

	@Test
	public void testPassenger() {
		Passenger testPassenger1 = new Passenger();
		String result = testPassenger1.getName();
		assertEquals("Unknown name",result);
	}

	@Test
	public void testSetName() {
		Passenger testPassenger2 = new Passenger();
		testPassenger2.setName("Nathan Friend");
	    assertEquals("Nathan Friend",testPassenger2.getName());
	}
	

}
