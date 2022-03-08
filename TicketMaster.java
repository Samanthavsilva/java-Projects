
//Program: This program will run as a ticketmaster

import java.util.Scanner;
import java.io.*;

public class TicketMaster {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader ("events-info.csv");
        System.out.println("Welcome to MejiaMaster");
        while (true) {
            System.out.println();
            System.out.println("\t" + "MAIN MENU" + "\t");
            System.out.println("What would you like to do?");
            System.out.println("1. View Events");
            System.out.println("2. View Concessions");
            System.out.println("3. Purchase tickets and concessions");
            System.out.println("4. Exit System");
            String viewEvents = "1";
            String viewConcessions = "2";
            String purchaseTicketsAndConcessions = "3";
            String exit = "4";
            double concessionPrice;
            double totalConcession = 0;
            double totalTicketCost = 0;
            int inputEvent = 0;
            boolean allowed = false;
            boolean inputEventOutput = false;
            double hotdogPrice = 0;
            double popcornPrice = 0;
            double sodaPrice = 0;
            double totalPopcornPrice = 0;
            double totalHotdogPrice = 0;
            double totalSodaPrice = 0; 
             Event ticketsEvent;
             //int eventtick = event[inputEvent- 1];
            Scanner scnr = new Scanner(System.in);
            String option = scnr.nextLine();
            
            if((option.equals(viewEvents)) || (option.equals(purchaseTicketsAndConcessions))){
                System.out.println("All Events:");
               
                // a event variable is created to call the read events method and called the view all event names where all events
                //and their information will show.
                Event [] event = fileReader.readEvents(); 

                viewAllEventNames(event);           
                if (option.equals(purchaseTicketsAndConcessions)){
                    System.out.println("Enter the number of the event you'd like to attend.");
                    inputEvent = scnr.nextInt();


                    //input event ouput variable is set to false so not false will go inside and check if the input the user enter
                    //is between 1 and 7 if not error message will print and variable will stay false to re enter the loop until it's true and exits
                    while (!inputEventOutput){
                        if ((inputEvent <= 0)|| (inputEvent > event.length)){
                             System.out.println("Invalid event number. Try again");
                            inputEventOutput = false;
                            inputEvent = scnr.nextInt();
                           
                        }
                       
                        else {
                            inputEventOutput = true;
                        }
                        
                    }     
                    if (inputEventOutput == true){
                        //inpit event is - 1 to access the index of the event array and therefore access which event number it is              
                        //Event 
                        ticketsEvent = event[inputEvent- 1];
                        System.out.println();
                        System.out.println("You selected: " +  ticketsEvent.getEventName());
                        System.out.println("Tickets for " + ticketsEvent.getEventName() +" cost " + "$"  + ticketsEvent.getTicketPrice());
                        System.out.println();
                        System.out.println("How many tickets would you like to buy ");
                        int ticketsToBuy = scnr.nextInt();
                        //method is called to see if user enters the correct amount of tickets available else an error message will show
                        boolean validTicketsAvailable = ticketsEvent.ticketsAreAvailable(ticketsToBuy);
                        //while valid tickets available is false then an error message will be printed until it is true and exits the loop
                        while (!validTicketsAvailable){
                            System.out.println();  
                            System.out.println("Invalid amount of tickets. Try again");
                            ticketsToBuy = scnr.nextInt();
                            validTicketsAvailable = ticketsEvent.ticketsAreAvailable(ticketsToBuy);
                            if (validTicketsAvailable == true){
                                validTicketsAvailable = true;
                            }
                    
                        }
                        if (validTicketsAvailable){
                        System.out.println();
                        System.out.println("Your purchase was available!");

                        //method is called to return the tickets purchased cost
                        double purchaseTickets = ticketsEvent.purchaseTickets(ticketsToBuy);
                        totalTicketCost += purchaseTickets;
                        System.out.println("You will be charged " + "$" + totalTicketCost+ " for tickets");
                        
                        // method is called to show the leftover tickets
                        int ticketsAvailable = ticketsEvent.getNumTicketsAvailable();
                        System.out.println("There are " + ticketsAvailable +  " left");
                        System.out.println();
                        System.out.println("Would you like to buy concessions? (y/n)");
                        String yesOrNo = scnr.next();
                        yesOrNo = yesOrNo.toLowerCase();
                        while (yesOrNo.equals("y")){
                            System.out.println("Here are all the concessions available at " + ticketsEvent.getEventName());
                            System.out.println();   

                            //the event variable is used to get the concession stands and print all their info     
                            (ticketsEvent.getConcessionStand()).printConcessionDetails();               
                            System.out.println("Which concession would you like to purchase?");
                            String concessionInput = scnr.next(); 
                            concessionInput = concessionInput.toLowerCase();
                            boolean correctConcession = false;
                            while(!correctConcession){  
                                if ((concessionInput.equals("popcorn")) || (concessionInput.equals("hotdog")) || (concessionInput.equals("soda"))){
                                    correctConcession = true;
                                }
                                else{
                                    System.out.println("Invalid concession option. Try again");
                                    concessionInput = scnr.next(); 
                                    concessionInput = concessionInput.toLowerCase();
                                    correctConcession = false;
                                }
                            }

                            if (correctConcession == true){       
                                System.out.println("How many of this item would you like to purchase?");
                                int itemInput = scnr.nextInt(); 
                                if (concessionInput.equals("popcorn")){
                                    //ticket event variable is used to get the concession stand from the event class and then all is used to get the popcorn price
                                    //from the concession class.
                                    popcornPrice = (ticketsEvent.getConcessionStand()).getPopcornPrice();
                                    totalPopcornPrice = itemInput * popcornPrice;
                                    totalConcession+=totalPopcornPrice;
                                }

                                if (concessionInput.equals("hotdog")){
                                    hotdogPrice = (ticketsEvent.getConcessionStand()).getHotdogPrice();
                                    totalHotdogPrice = itemInput * hotdogPrice;
                                    totalConcession+=totalHotdogPrice;
                                
                                }

                                if (concessionInput.equals("soda")){
                                    sodaPrice = (ticketsEvent.getConcessionStand()).getSodaPrice();
                                    totalSodaPrice = itemInput * sodaPrice;
                                    totalConcession+=totalSodaPrice;
                                     
                                }
                            
                                System.out.println("Would you like to buy any more concessions? (y/n)"); 
                                yesOrNo = scnr.next(); 
                                yesOrNo = yesOrNo.toLowerCase();
                            }
                           
                                  
                        }
                        if (yesOrNo.equals("n")){
                          

                            System.out.println("Ticket charge: " + "$"  + totalTicketCost);
                            System.out.println("Concession charge: "  + "$"  + totalConcession);
                            double subtotal = totalConcession + totalTicketCost;
                            System.out.println("Subtotal charge " + "$" + subtotal ); 
                            if((totalTicketCost == 0) && (totalConcession == 0)){
                                System.out.println();
                                System.out.println("Purchase is complete. Thank you for using MejiaMaster!");
                            }
                            else {
                                System.out.println("Please enter a 16 digit credit card number to complete purchase");
                                String creditCard = scnr.next();
                                //method is called to determine if the credit card is 16 length and only numbers
                                boolean validCreditCard = isCreditCardNumberValid(creditCard);                     
                                while (!validCreditCard){
                                    System.out.println();
                                    System.out.println("Invalid credit card. Please try again.");//see why it prints double on first time
                                    creditCard = scnr.next();
                                    validCreditCard = isCreditCardNumberValid(creditCard);
                                    if(validCreditCard == true){
                                        break;
                                    }
                                }
                         
                                if (validCreditCard){
                                        //method to determine the last four digits of the credit card is called
                                        String lastFour = lastFourDigits(creditCard);
                                        System.out.println();
                                        System.out.println("Your card ending in " + lastFour + " was charged " + "$" + subtotal + ". Thanks for your purchase, thanks for using MejiaMaster!");
                                        System.out.println();
                                        break;
                                }  
                            }             
                       
                        }

                                  
                        }
                     
                    }
                  
                }
            }

            else if (option.equals(viewConcessions)){
                System.out.println("All Concessions:");
                System.out.println();
                // new event variable is created to call the read events method and the view all concessions method to print the concessions information
                Event [] concessionInfo = fileReader.readEvents();
                viewAllConcessions(concessionInfo);
            }

            else if (option.equals(exit)){
                System.out.println("Thank you for using MejiaMaster, have a great day!");
                break;
            }
      
        }
    }
    //method to return a string with only the last four digits containing from a string
    public static String lastFourDigits (String creditCardNumber){ 
        String lastFour = "";
        if (creditCardNumber.length() > 4){
            lastFour = creditCardNumber.substring(creditCardNumber.length() - 4);
        }
        else {
            lastFour = creditCardNumber;
        }
        return lastFour;
    }

    //method to determine the length of the card if it is 16 and if so a for loop is created and a boolean to determine there all
    //numbers in the string
    public static boolean isCreditCardNumberValid(String creditCardNumber){
        boolean valid = false;
        
        if (creditCardNumber.length() != 16){
            valid = false;
        }
        else {
            for (int i = 0; i < creditCardNumber.length(); i++){
                boolean numbers = Character.isDigit(creditCardNumber.charAt(i));
                if (numbers){
                    valid = true;
                }
                else {
                    valid = false;
                }
            }
        }     
        
        return valid;
    }

    //method to print all the event and their event details
    public static void viewAllEventNames(Event[] events){
        for (int i = 0; i < events.length; i++){
            System.out.println("\t"+ "Event" + " "+ (i+1) + "\t");
            events[i].printEventDetails();
        } 
    }
    //method to print all event name and their concessions with their details
    public static void viewAllConcessions(Event [] events){
        for (int i = 0; i < events.length; i++){
            Event tickets = events[i];
            System.out.println(tickets.getEventName());
            (events[i].getConcessionStand()).printConcessionDetails();
           
        }
    }
}

