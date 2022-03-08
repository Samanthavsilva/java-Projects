
import java.io.*;
import java.util.Scanner;

public class Event {

	private String eventName;
	private String eventAddress;
	private String venueName;
	private int numTicketsAvailable;
	private double ticketPrice;
	Concession concessionStand;
	


	//Default constructors
	public Event() {}
	//Constructos
	public Event(String eventName, String venueName, String eventAddress, double ticketPrice, int numTicketsAvailable, Concession concessionStand){
		this.eventName = eventName;
		this.venueName = venueName;
		this.eventAddress = eventAddress;
		this.ticketPrice = ticketPrice;
		this.numTicketsAvailable = numTicketsAvailable;
		this.concessionStand =  concessionStand;
	}

	//Setters
	public void setEventName(String eventName){
		this.eventName = eventName; 
	}
	public void setAddress(String eventAddress){
		this.eventAddress = eventAddress;
	}
	public void setVenueName(String venueName){
		this.venueName = venueName;
	}
	public void setNumTicketsAvailable(int numTicketsAvailable){
		this.numTicketsAvailable = numTicketsAvailable;
	}
	public void setConcessionStand(Concession concessionStand){
		this.concessionStand = concessionStand;
	}
	public void setTicketPrice(double ticketPrice){
		this.ticketPrice = ticketPrice;
	}


	//Getters

	public String getEventName(){
		return this.eventName;
	}
	public String getAddress(){
		return this.eventAddress;
	}
	public String getVenueName(){
		return this.venueName;
	}
	public int getNumTicketsAvailable(){
		return this.numTicketsAvailable;
	}
	public double getTicketPrice(){
		return this.ticketPrice;
	}
	public Concession getConcessionStand(){
		return this.concessionStand;
	}
	//method to return true or false if the amount of tickets available is correct
	public boolean ticketsAreAvailable(int numTickets){
		if ((numTickets <= this.numTicketsAvailable) && (numTickets > 0)){
			return true;
		}
		return false;
	}
	//method to return the tickets cost and subtract the tickets available when purchased
	public double purchaseTickets(int numTickets){
		boolean ticketsAvailable = ticketsAreAvailable(numTickets);
		double ticketsCost = 0;
		if (ticketsAvailable){
			
			this.numTicketsAvailable = this.numTicketsAvailable - numTickets;
		
			ticketsCost = (numTickets) * this.ticketPrice;
		}
	
		return ticketsCost;
		
	}

	//print details
	public void printEventDetails(){
		System.out.println("Event Name: " + this.eventName);
		System.out.println("Venue Name: " + this.venueName);
		System.out.println("Address: " + this.eventAddress);
		System.out.println("Ticket Price: "+ "$" + this.ticketPrice);
		System.out.println("Number of Tickets Available: " + this.numTicketsAvailable);
		System.out.println();

	}
}









