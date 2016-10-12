package org.nathanfriend.reservations;
import java.sql.*;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
	//fields
	private ArrayList<Seat> seats;
	private ArrayList<Passenger> passengers;
	private ArrayList<Flight> flights;
	private ArrayList<Ticket> tickets;

	private static Logger databaseLog = Logger.getLogger(Database.class.getName());
	private static ConsoleHandler logScreen = new ConsoleHandler();
	
	//constructor
	public Database() {
		seats = new ArrayList<Seat>();
		passengers = new ArrayList<Passenger>();
		flights = new ArrayList<Flight>();
		tickets = new ArrayList<Ticket>();
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void addSeat(int seatNumner) {
		seats.add(new Seat(seatNumner));
		
	}

	public boolean addPassenger(String passengerName) {
		boolean passengerExists = false;
		for (Passenger item : getPassengers()) {
			if (passengerName.equals(item.getName())) {
				passengerExists = true;
			}
		}
		if (passengerExists == false) {
			passengers.add(new Passenger(passengerName));
		}
		return passengerExists;
	}

	public void addFlight(int flightNumber,String departureCity, String arrivalCity) {
		flights.add(new Flight(flightNumber, departureCity, arrivalCity));
	}
	
	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, int seatNumber) {
		databaseLog.fine("Beginning ticket creation");
		//find the passenger object
		databaseLog.fine("Finding passenger");
		Passenger ticketPassenger = null;
		for (Passenger item: getPassengers()) {
			if (passengerName.equals(item.getName())) {
				ticketPassenger = item;
			}
		}
		
		//find flight object
		databaseLog.fine("Finding flight");
		Flight ticketFlight = null;
		for (Flight item: getFlights()) {
			databaseLog.finer("Comparing " + flightNumber + " to flight " + item.getFlightNumber());
			if (flightNumber == item.getFlightNumber()) {
				ticketFlight = item;
			}
		}
		
		//find seat object
		databaseLog.fine("Finding seat");
		Seat ticketSeat = null;
		for (Seat item : getSeats()) {
			if (seatNumber == item.getSeatNumber()) {
				ticketSeat = item;
			}
		}
		
		
		Ticket tempTicket = new Ticket();
		tempTicket.setDepartureDate(departureDate);
		tempTicket.setPassenger(ticketPassenger);
		tempTicket.setFlight(ticketFlight);
		tempTicket.setSeat(ticketSeat);
		tickets.add(tempTicket);
		databaseLog.info("Ticket created.");
		return tempTicket.toString();
	}
	
	public void setLogging() {
		databaseLog.addHandler(logScreen);
		databaseLog.setLevel(Level.OFF);
		logScreen.setLevel(Level.OFF);
		databaseLog.setUseParentHandlers(false);
	}
	
	public ArrayList<Seat> getOpenSeats(LocalDate departureDate, int flightNumber) {
		ArrayList<Seat> openSeats = getSeats();
		for (Ticket item : getTickets()) {
			if (departureDate.equals(item.getDepartureDate()) && flightNumber == item.getFlight().getFlightNumber())
			openSeats.remove(item.getSeat());
		}
		return openSeats;
	}
	
	public void bootstrap() {
		addSeat(1);
		addSeat(2);
		addSeat(3);
		addSeat(4);
		addSeat(5);
		addSeat(6);

		addFlight(1000, "Los Angles", "Chicago");
		addFlight(1010, "Chicago", "Los Angles");
		addFlight(2000, "New York", "Chicago");
		addFlight(2010, "Chicago", "Los Angeles");
	}
	
	public void bootstrapMysql() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://10.10.1.156:8036/javadev","root","189pabx");   
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from contacts");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4) );  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  

	}
	
	public void bootstrapCSV() {
		try {
			BufferedReader flightImport = new BufferedReader(new FileReader("/Users/nfriend/eclipse/Reservations/import/flights.csv"));
			String flightLine;
			while ((flightLine = flightImport.readLine()) != null) {
				System.out.println(flightLine);
			}
			flightImport.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public void exportSeat() {
		try {
			BufferedWriter seatExport = new BufferedWriter(new FileWriter("/Users/nfriend/eclipse/Reservations/export/seats.csv"));
			for (Seat item : getSeats()) {
				seatExport.write(item.toString()+ "\n");
			}
			seatExport.close();
			System.out.println("File export OK.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
