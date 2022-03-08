import java.util.Scanner;

public class Concession {

	private double popcornPrice = 6.0;
	private double sodaPrice = 1.50;
	private double hotdogPrice = 4.0;

	public Concession(){}
	//Constructors 
	public Concession(double popcornPrice, double sodaPrice, double hotdogPrice){
		this.popcornPrice = popcornPrice;
		this.sodaPrice = sodaPrice;
		this.hotdogPrice = hotdogPrice;
	}
	//setters
	public void setPopcornPrice(double popcornPrice){
		this.popcornPrice = popcornPrice; 
	}
	public void setSodaPrice(double sodaPrice){
		this.sodaPrice = sodaPrice;
	}
	public void setHotdogPrice(double hotdogPrice){
		this.hotdogPrice = hotdogPrice;
	}

	//Getters
	public double getPopcornPrice(){
		return this.popcornPrice;
	}
	public double getSodaPrice(){
		return this.sodaPrice;
	}
	public double getHotdogPrice(){
		return this.hotdogPrice;
	}

	//method to apply the corresponding price factor to the concessions price
	public void applyPriceFactor(double priceFactor){
		this.popcornPrice *= priceFactor;
		this.sodaPrice *= priceFactor;
		this.hotdogPrice *= priceFactor;
	}

	//print details
	public void printConcessionDetails(){
		System.out.println("Popcorn: " + "$" + this.popcornPrice);
		System.out.println("Soda: " + "$" + this.sodaPrice);
		System.out.println("Hotdog: " + "$" + this.hotdogPrice);
		System.out.println();

	}

}