import java.io.*;

import java.util.Scanner;


public class mart {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("fruits-database.txt");
        /*These are the declared and initialized variables I will be using in more 
        than one condition and loop*/
        double fruitPrice;
        double totalPrice = 0;
        double cartWeight = 0;
        double totalWeight = 0;
        double currentPrice = 0;
        Scanner consoleScnr = new Scanner(System.in);
        boolean menu = true;
        System.out.println("Welcome to Mejia Mart!");
        /* Add a while to the whole code so the menu options print the menu each time an option is
        done */
        while (menu){
            System.out.println();
            System.out.println("Please select an option!");
            System.out.println("1. Add item");
            System.out.println("2. View cart");
            System.out.println("3. Clear cart");
            System.out.println("4. Check out");
            System.out.println("5. Exit");

            /* The menu options were set to strings to the number they belong to so user 
            inputs number and it corresponds to the menu options*/
            String item = "1";
            String cart = "2";
            String clear = "3";
            String checkOut = "4";
            String exit = "5";
            String option =  consoleScnr.nextLine();

            /* If option is the same number corresponding to item then a
            while was added to print the fruit and price*/
            if (option.equals(item)){
                Scanner fileScnr = new Scanner(file);
                System.out.println("Here are all available fruits");
                while (fileScnr.hasNextLine()){
                    String fruitList = fileScnr.next();
                    fruitPrice = fileScnr.nextDouble();
                    System.out.println(fruitList);
                    System.out.println(fruitPrice);
                }
            
               
                System.out.println("Enter the name of the fruit you'd like to add");
                String fruitInput = consoleScnr.nextLine();

                /* A new file scanner was added to determine if the fruit inputted macthes one of 
                the fruits from the list*/
                Scanner newFileScnr = new Scanner(file); 
                boolean fruitFound = false;

                /*A while loop is added so the total weight and total price is calculated each time
                  more fruit is chosen */ 
                while (newFileScnr.hasNextLine()){
                
                    String newList = newFileScnr.next();
                    if (fruitInput.equals(newList)){
                        fruitFound = true;
                       
                        System.out.println("How many pounds of this fruit are you adding?"); 
                        double fruitPounds = consoleScnr.nextDouble();
                        fruitPrice = newFileScnr.nextDouble();
                        currentPrice = fruitPounds * fruitPrice;
                        cartWeight = fruitPounds;
                        totalWeight+=cartWeight;
                        totalPrice+=currentPrice;
                        System.out.println("Your current total weight is " + totalWeight + " and your current total price is $" + totalPrice);
                       
                    }



                    
                     
                     


                }
                /* If fruit inputted does not match from the fruit list then fruit found is false 
                and an error message is printed*/
                if (!fruitFound){
                        System.out.println("Error please try again");
                }

            }
             
            /* If option input is the same number corresponding to cart then
            the total weight and total price is printed*/
            else if (option.equals(cart)){
                    
                System.out.println("Your current total weight is " + totalWeight+ " and your current total price is $" + totalPrice);
            }        
            /* If option input is the same number corresponding to clear then
            the total weight and total price is set to zero so the cart is clear*/    
            else if (option.equals(clear)){
                totalWeight = 0;
                totalPrice = 0.00;
                System.out.println("Cart Cleared");
      
            }

            /* If option input is the same number corresponding to checkout then
            then the bags brought, total price, gift card, gift card balance are found*/
            else if (option.equals(checkOut)){
                System.out.println("Time for checkout how many bags did you bring?");
                int bagsBrought = consoleScnr.nextInt();
                int bagsNeeded = (int) Math.ceil(totalWeight / 5 - bagsBrought);
                int bagsBroughtWeight = bagsBrought * 5;
                double additionalBagsCost = 0.15 * bagsNeeded;



                /* If the weight of the bags brought is less 
                than the total weight then additional bags will be added and their cost*/
                if (bagsBroughtWeight < totalWeight){

                    System.out.println("Your total weight is " + totalWeight + " pounds so you need to purchase " + bagsNeeded + " additional bags which cost " + additionalBagsCost + ". Your total is " + totalPrice);
                    System.out.println("Enter gift card amount");
                    int giftCard = consoleScnr.nextInt();

                        /* If the gift card amount matches the price amount or is greater, then remaining
                        balance will be printed*/
                        if (giftCard >= totalPrice){
                            double giftCardBalance = giftCard - totalPrice;
                            System.out.println("Thank you for shopping at MejiaMart, come back soon!");
                            System.out.println("Remaining gift card balance: " + giftCardBalance);
                        }
                        else {
                            System.out.println("Insufficient funds");
                        }
     

                }
                /* If the weight of the bags brought is greater than or equals to the total weight
                amount then only the total will be printed*/
                else if (bagsBroughtWeight >= totalWeight){
                    System.out.println("Your total is $" + totalPrice);
                    System.out.println("Enter a gift card amount");
                    int giftCard = consoleScnr.nextInt();
                    if (giftCard >= totalPrice){
                        double giftCardBalance = giftCard - totalPrice;
                        System.out.println("Thank you for shopping at MejiaMart, come back soon!");
                        System.out.println("Remaining gift card balance: " + giftCardBalance);
                    }
                    else {
                        System.out.println("Insufficient funds");

                    }
                }
     
            }
            else if (option.equals(exit)){
                System.out.println("GoodBye :)");
                break;
            }


            }
     

    }
}















