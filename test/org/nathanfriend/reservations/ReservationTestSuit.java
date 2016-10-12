package org.nathanfriend.reservations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightTest.class, PassengerTest.class, SeatTest.class })
public class ReservationTestSuit {

}
