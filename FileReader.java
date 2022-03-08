
import java.io.*;
import java.util.Scanner;

public class FileReader{
	//attributes
	private String fileName;
	
	//constructors
	public FileReader(){}

	public FileReader(String fileName){
		this.fileName = fileName;
	}
	//setter
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	//getter
	public String getFileName(){
		return this.fileName;
	}
	
	//method to read the events and concessions information from the file reader when called
	public Event[] readEvents() throws FileNotFoundException{
		Event [] eventArr = new Event [getNumEvents()];
		int i = 0;
		File file = new File(fileName);
		Scanner fileScnr = new Scanner(file);
		fileScnr.nextLine();
		while (fileScnr.hasNextLine()){
			String line = fileScnr.nextLine();
			String[] arr = line.split(",");
			Concession concession = new Concession();
			concession.applyPriceFactor(Double.parseDouble(arr[5]));
			Event event = new Event(arr[0], arr[1], arr[2], Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), concession);
			eventArr[i] = event;
			i++;
		}
		return eventArr;
		
	}
	//method to count only the rows from the array
	public int getNumEvents() throws FileNotFoundException{
		int count = 0;
		File file = new File(fileName);
		Scanner fileScnr = new Scanner(file);
		fileScnr.nextLine();
		while (fileScnr.hasNextLine()){
			String line = fileScnr.nextLine();
			count++;

			
		}
		return count;

	}
}
