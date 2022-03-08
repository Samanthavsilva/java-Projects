import java.util.Scanner;
import java.io.*;

// Example program showcasing the java .split() method.
// You can use this concept in the readEvents() method in FileReader.java
// for CL3.
public class SplitMethod {
	public static void main(String[] args) throws FileNotFoundException {

		// Initialize Scanner to read csv file.
		File file = new File("events-info.csv");
		Scanner fileScnr = new Scanner(file);

		// Skip the first line of the file (because it just contains column names).
		fileScnr.nextLine();

		// For every line in the CSV file...
		while (fileScnr.hasNextLine()) {

			// Read the line of comma separated values
			String line = fileScnr.nextLine();

			// "Split" the string by a comma, which gives an array of values.
			String[] lineValues = line.split(",");

			// Print all the values in the array.
			System.out.println("Event name: " + lineValues[0]);
			System.out.println("Venue name: " + lineValues[1]);
			System.out.println("Event address: " + lineValues[2]);
			System.out.println("Ticket price: " + Double.parsedouble(lineValues[3]));
			System.out.println("Tickets available: " + Integer.parseInt(lineValues[4]));
			System.out.println("Concession factor: " + Double.parsedouble(lineValues[5]));
			System.out.println();

			// Now, you can create a Concession and Event object from this line using these values!
		}
	}
}