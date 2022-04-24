import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {
	public static ArrayList<Vehicle> vehicles = new ArrayList<>();		// this array list will contain all vehicles and will used in all methods
	static Scanner sysSc = new Scanner(System.in);						//in our system, the program will stay reading from console all the time, so the scanner created here
	public static int isFileHasBeenRead = 0, isPetroleumPriceSet = 0, isDataSavedInFile = 0, isSorted = 0;
	
	
	
	
	public static void main(String[] args) throws CloneNotSupportedException, IOException {
		
		try {
			displaymMenu();

			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
	
	}
	
	
	
	
	
	//displaymMenu() method will display the menu of all the system functions, and let the user to choose from them
	//then it will direct the the system to method chose
	public static void displaymMenu() throws CloneNotSupportedException, IOException{
			while(true) {			//while(true) to let the system ask the user to enter process until the system exit by ((System.exit()))
			
				System.out.println("\n\n----Please select the number you want choose----\n"
									+ "1) Read the data from \"inputdata.txt\".\n"
									+ "2) Set prices of petroleum.\n"
									+ "3) Print sorted order Vehicles in an ascending order based on costFor100Km.\n"
									+ "4) Print sorted order Vehicles in an ascending order based on owner name.\n"
									+ "5) Print sorted order Vehicles in an descending order based on vehicle brand.\n"
									+ "6) Print full information about all Vehicles.\n"
									+ "7) Clone Vehicle without owner.\n"
									+ "8) Turn air-condition ON.\n"
									+ "9) Turn air-condition OFF.\n"
									+ "10) Write Output on the \"output.txt\".\n"
									+ "11) Exit from system.\n\n");
				
				int selection;
				try {
					selection = sysSc.nextInt();		//reading the selection from the console
				
					if (selection >= 3 && selection <= 10) {			//the user must read data from input file and set petroleum price before start using other functions
						if (isFileHasBeenRead == 0) {				//isFileHasBeenRead value will change only after reading the file
							System.out.println("You should get the data from file first, choose 1 to read file");
							continue;			//this is to ignore the switch statement and exit the loop
						}
						
						if (isPetroleumPriceSet == 0) {				//isPetroleumPriceSet value will change only after the price set
							System.out.println("You have to set petroleum price first, choose 2 to set gasoline and desiel prices");
							continue;			////this is to ignore the switch statement and exit the loop
						}
						
					}
					
					
					switch (selection) {
						case 1: {
							readFile();
							break;
						}
						
						case 2: {
							setPetroleumPrice();
							break;
						}
						
						case 3: {
							sortBy100kmCost();
							break;
						}
						
						case 4: {
							sortByOwnerName();
							break;
						}
						
						case 5: {
							sortByBrand();
							break;
						}
						
						case 6: {
							printAllVehicelsAllInfo();
							break;
						}
						
						case 7: {
							cloneVehicle();
							break;
						}
						
						case 8: {
							turnAirCondition("ON");
							break;
						}
						
						case 9: {
							turnAirCondition("OFF");
							break;
						}
						
						case 10: {
							printOnFile();
							break;
						}
						
						case 11: {
							exitTheSystem();
							break;
						}
						
						default:
							System.out.println("Please enter number from 1 to 11");		//if user enter an integer not from the list, this message will appear 
							break;
					}
					
				
					if (selection >= 1 && selection <=8) {
						isDataSavedInFile = 0;			
						//if the user make ant changes like cloning or sorting of changing prices, isDataSavedInFile will return to zero
						//that mean that the data does not saved in the output file yet
					}
					
					
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");		//this message will appear if the user enter invalid input like string or character 
					sysSc.nextLine();	//Empty the scanner before the next iteration
				}
			}
		}
	
	
	
	
	
	

	
	//readFile() method catches the information from the input file and store them in the ArrayList
	public static void readFile() throws FileNotFoundException {
		File inputFile = new File("inputdata.txt");
		vehicles.clear();
		Scanner fileSc = new Scanner(inputFile);
		int lineNumber=1;		//this variable to show which line has error when handling the exception
		
		while (fileSc.hasNext()) {		//this while loop will end just when no more data in the file to read
			
						
			/* 
			 * In the project, it asks us to use StringBuilder to splitting, but really that doesn't mean anything; because the split() method
			 * is for String type, not for StringBuilder, and there is no any method in StringBuilder class that splits it. So, if we do it as
			 * written in the project, we will create a String then store it in StringBuilder then again change it to String to use split()
			 * method and store it again in String.... So there is no need to use to StringBuilder as we work on String class not on StringBuilder
			 */
			
			/*
			 * I can use StringBuilder but there is no need to it, and it's just a new lines without any purpose
			 */
			
			/* 
//			here is how to use String Builder:
//			StringBuilder strB = new StringBuilder(fileSc.nextLine());
//			String[] info = strB.toString().split([",");
			*/
			
			String[] info = fileSc.nextLine().split("[,]");		//the program reads the whole line as string, then split it and store it in an array of strings 

			
			//this for loop to remove spaces from the begin and the end of string (the real purpose is to avoid errors when casting strings to doubles and integers)
			for (int i = 0; i < info.length; i++){
				info[i] = info[i].trim();
			}
			
			
			int engineType = (info[4].compareTo("Diesel") == 0)? PetroleumType.DIESEL : 
				(info[4].compareTo("Gasoline") == 0)? PetroleumType.GASOLINE : 
				(info[4].compareTo("Hybrid") == 0)? 3 :
				-1;
			
			/*
			 * This means:
			 * if info[4] is Diesel, then set engineType to PetroleumType.DIESEL Hybrid
			 * else if info[4] is Gasoline, then set engineType to PetroleumType.GASOLINE
			 * else if info[4] is Hybrid, then set engineType to 3
			 * else (if unknown value), set  engineType to -1
			 */
			
			
			
			
			String[] dateStr = info[11].split("[-]"); 			 //info[11] contains the complete date in one string, this line to split day and month and year each in a string 
			int[] date = {Integer.parseInt(dateStr[0].trim()), Integer.parseInt(dateStr[1].trim()), Integer.parseInt(dateStr[2].trim())};	//storing the date in array of integers
			
			//info[0] contains the type of vehicle, so we depend on it to determine the type
			try {
				switch(info[0]) {
					case "Car": {
						vehicles.add(new Car(
										 info[1], 
										 info[2],
										 info[3],
										 engineType,
										 Double.valueOf(info[5]),
										 Double.valueOf(info[6]),
										 new Owner(info[7], info[8], info[9], info[10], new GregorianCalendar(date[2], date[1], date[0])),
										 Integer.parseInt(info[12])
						));
						break;
					}
					
					
					
					case "MiniVan": {
						vehicles.add(new Minivan(
										 info[1], 
										 info[2],
										 info[3],
										 engineType,
										 Double.valueOf(info[5]),
										 Double.valueOf(info[6]),
										 new Owner(info[7], info[8], info[9], info[10], new GregorianCalendar(date[2], date[1], date[0])),
										 Integer.parseInt(info[12]),
										 Boolean.parseBoolean(info[13])
						));
						break;
					}
					
					
		
					
					case "Truck": {
						vehicles.add(new Truck(
										 info[1], 
										 info[2],
										 info[3],
										 engineType,
										 Double.valueOf(info[5]),
										 Double.valueOf(info[6]),
										 new Owner(info[7], info[8], info[9], info[10], new GregorianCalendar(date[2], date[1], date[0])),
										 Integer.parseInt(info[12]),
										 Integer.parseInt(info[13])
						));
						break;
					}
					
				}

				
			} catch (IllegalArgumentException e) {		//this will catch exceptions from vehicle sub classes
				System.out.println("[Line " + lineNumber + "]: " + e.getMessage());		//this will display the error line with it
				
				
			}
			
			lineNumber++;
					
		}
		
		fileSc.close();		//close the file scanner
		System.out.println("Data has been read from the \"input.txt\" file");
		isFileHasBeenRead = 1;		//to let the user use other functions after read the file
	}
	
	
	
	
	
	
	
	//setPetroleumPrice() method will set the price of gasoline and diesel
	public static void setPetroleumPrice(){
		int flag1 = 0, flag2 = 0;		//these flags used in exceptions loops
		
		while (flag1 == 0) {		//the value of the flag will change just when no errors
			try {
				System.out.print("Enter Gasoline price (NIS/liter):  ");
				PetroleumType.setGasolinePrice(sysSc.nextDouble());		//read the value from console and set it to gasoline
				flag1 = 1;			//if no errors, change the flag value to end the loop
			
			} catch (InputMismatchException e) {
				System.out.println("Invalid Gasoline price");
				sysSc.nextLine();	//Empty the scanner before the next iteration
			}
			
		}
		

		
		while (flag2 == 0) {		//the value of the flag will change just when no errors
			try {
				System.out.print("Enter Dieslel price (NIS/liter):  ");
				PetroleumType.setDieselPrice(sysSc.nextDouble());		//read the value from console and set it to diesel
				flag2 = 1;			//if no errors, change the flag value to end the loop
			
			} catch (InputMismatchException e) {
				System.out.println("Invalid Dieslel price");
				sysSc.nextLine();	//Empty the scanner before the next iteration
			}
				
		}
		
		
		isPetroleumPriceSet = 1;		//to let the user use other functions after set the prices
		
	}

	
	
	
	
	
	
	public static void sortBy100kmCost() {

		
		vehicles.sort(new SortBy100Cost());		//sort using Comparator interface
		printAllVehicelsShortInfo();			//print the ArrayList after sorting
		isSorted = 1;							//to let the user to save the file, because the user should sort the values before save them in the file
	}
	
	
	public static void sortByOwnerName() {
		
		vehicles.sort(new SortByOwnerName());	//sort using Comparator interface
		printAllVehicelsShortInfo();			//print the ArrayList after sorting
		isSorted = 1;							//to let the user to save the file, because the user should sort the values before save them in the file
	}
	
	
	public static void sortByBrand() {
		
		vehicles.sort(new SortByBrand());		//sort using Comparator interface
		printAllVehicelsShortInfo();			//print the ArrayList after sorting
		isSorted = 1;							//to let the user to save the file, because the user should sort the values before save them in the file
	}
	
	
	
	

	//printAllVehicelsAllInfo() method used to show all information about all vehicles
	public static void printAllVehicelsAllInfo() {
		for (Vehicle i:vehicles) 
			System.out.println(i.toString());
	}
	
	
	
	
	
	
	//cloneVehicle() method clones one vehicle and add it to the end of the ArrayList
	public static void cloneVehicle() throws CloneNotSupportedException {
		
		printAllVehicelsShortInfo();		//print all vehicles to choose one to clone
		
		int flag = 0;		//this flag value will change only if no exceptions errors, if there is an exception error, the program will ask the user to enter vehicle number again
		while (flag == 0) {
			try {
				System.out.print("\nEnter the number of the vehicle you wanna clone:  ");
				int vehicleNumber = sysSc.nextInt()-1;		//because its shown to the user starting from 1 not from 0
				
				
				//to make sure that the user will enter a valid vehicle number, not number of a non exist vehicle
				while (vehicleNumber < 0 || vehicleNumber >= vehicles.size()) {
					System.out.print("Error, number should be from 1 to " + vehicles.size() + ". Please enter number again:   ");
					vehicleNumber = sysSc.nextInt()-1;
					
				}
				
				
				
				//clone the vehicle depending on its type by casting it after cloning
				Vehicle newVehicle;
				if (vehicles.get(vehicleNumber) instanceof Car) {
					newVehicle = (Car) vehicles.get(vehicleNumber).clone();
				
				} else if (vehicles.get(vehicleNumber) instanceof Minivan) {
					newVehicle = (Minivan) vehicles.get(vehicleNumber).clone();
				
				} else if (vehicles.get(vehicleNumber) instanceof Truck) {
					newVehicle = (Truck) vehicles.get(vehicleNumber).clone();
				
				} else {
					newVehicle = new Car();			//this condition will never happen, its just to avoid errors below
					
				}
				
				
				//asks the user if he would like to set a new owner be entering its info
				sysSc.nextLine();
				String option = "";		//initial value to start the loop
				
				while (option.toUpperCase().compareTo("Y") != 0 && option.toUpperCase().compareTo("N") != 0) {		//selection should be Y or N only. (Ignore cases)
					System.out.println("Would you like to set a new owner info? Enter Y to set new info. N to leave it null");
					option = sysSc.nextLine();		//read if the user would like to set a new owner or no

					if (option.toUpperCase().compareTo("Y") == 0) {			//if the user would like to set a new owner
						System.out.print("Enter new owner info:\nName: ");	//asking the name for the new owner 
						newVehicle.getOwner().setName(sysSc.nextLine());	//reading new user name
						
						System.out.print("Registration Number: ");			//asking the user for new owner registration number
						newVehicle.getOwner().setRegisterionNo(sysSc.nextLine());	//reading the registration number for the new owner
						
						System.out.print("Address: ");						//asking the user for new owner address
						newVehicle.getOwner().setAddress(sysSc.nextLine());	//reading new owner address
						
						System.out.print("Telephone Number: ");				//asking the user for new owner telephone number
						newVehicle.getOwner().setTel(sysSc.nextLine());		//reading the new owner phone number
					
					} else if (option.toUpperCase().compareTo("N") == 0) {	//if the user doesn't like to set a new owner
						newVehicle.setOwner(null);							//the owner will be leave null
					
					} else {		//if invalid input (any thing unless Y or N)
						System.out.println("Enter Y to set new info. N to leave it null ");
					
					}
				}
				
				
				
				
				vehicles.add(newVehicle);		//adding the new vehicle after cloning it to the ArrayList
				flag = 1;				//that mean that the process done without any problems, and that will end the loop
			
			} catch (InputMismatchException e) {	//exception if the user enter a string instead of integer
				System.out.print("Invalid Input");
				sysSc.nextLine();	//Empty the scanner before the next iteration
			}
				
		}
		
	}
	

	
	
	
	//turnAirCondition() method asks the user to enter vehicle number to turn its condition ON or OFF depending on the parameter
	public static void turnAirCondition(String OnOff) {

		
		printAllVehicelsShortInfo();	//list the vehicles to choose one to change its condition status
		
		
		int flag = 0;		//this flag will change only if the process done without problems
		while (flag == 0) {
			try {
				System.out.print("\nEnter the number of the car you wanna turn its air condition " + OnOff + ":  ");
				int vehicleNumber = sysSc.nextInt()-1;		//because its shown to the user starting from 1 not from 0
				
				
				//to make sure that the user will enter a valid vehicle number, not number of a non exist vehicle
				while (vehicleNumber < 0 || vehicleNumber >= vehicles.size()) {
					System.out.print("Error, number should be from 1 to " + vehicles.size() + ". Please enter number again:   ");
					vehicleNumber = sysSc.nextInt()-1;
					
				}
				
				
				if (OnOff == "ON")
					vehicles.get(vehicleNumber).setAirConditionON();	//if the parameter is "ON", it will call vehicle setAirConditionON() method
				
				else 
					vehicles.get(vehicleNumber).setAirConditionOFF();	//if the parameter is "OFF", it will call vehicle setAirConditionOFF() method

				
				flag = 1;	//that means that the process done without errors, and will end the loop
			
			} catch (InputMismatchException e) {	//if the user enter invalid input like string or character or double instead of integer
				System.out.print("Invalid Input");
				sysSc.nextLine();	//Empty the scanner before the next iteration
			}
				
		}
		
	}
	
	
	
	
	
	//printOnFile() method saves the content of the ArrayList in "output.txt" file, its allowed just if the user already sort the data
	public static void printOnFile() throws IOException, CloneNotSupportedException {
		
		if (isSorted == 1) {		//to make sure that data sorted
			File file = new File("output.txt");
			PrintWriter out = new PrintWriter(file);
			
			for (Vehicle i:vehicles) {
				out.println(i.toString());		//printing data on out PrintWriter that refers to "output.txt" file
			}
			
			System.out.println("Data saved on \"output.txt\" file");		//confirmation message that the data saved successfully
			
			out.close();		//closing PrintWriter
			isDataSavedInFile = 1;		//this variable used in exitTheSystem() method
		}
		
		
		
		else {
			System.out.println("You have not used any sorting method, sort data first then save it on file");
			displaymMenu();
		}
	}
	
	
	
	
	
	//exitTheSystem() method makes sure that data saved in the file. If its, it will exit the system. If not, it will notify the user and asks them what to do
	public static void exitTheSystem() throws IOException, CloneNotSupportedException {

		sysSc.nextLine();		//just to clean the scanner
		if (isDataSavedInFile == 0) {		//if the data doesn't saved
			
			System.out.println("You haven't save the data in the output file\nEnter S to save it and exit, E to exit without save, B to go back to the menu: ");
			String selection = sysSc.nextLine().trim().toUpperCase();
			
			while (true) {
				
				switch (selection) {
					case "S": {		//saving data on the file then exit the system
						printOnFile();
						System.out.println("Thanks for using our system.. Exiting system...");
						System.exit(0);
					}
					
					case "E": {		//just exit the system without saving data
						System.out.println("Thanks for using our system.. Exiting system...");
						System.exit(0);
					}
					
					case "B": {		//back to main menu
						displaymMenu();
						break;
					}
					
					default: {		//if the user enters invalid option
						System.out.println("Enter S to save it and exit, E to exit without save, B to go back to the menu: ");
						selection = sysSc.nextLine().trim().toUpperCase();
					}
				}
			}
		}
		
		
		System.out.println("Thanks for using our system.. Exiting system...");
		System.exit(0);
	}

	
	
	
	
	//printAllVehicelsShortInfo() method used in other method like cloneVehicle and turnAirCondition
	//this method displays a short info about vehicles
	public static void printAllVehicelsShortInfo() {
		for (int i = 0; i < vehicles.size(); i++)
			System.out.println((i+1) + ") " + vehicles.get(i).shortToString());
	}
	
}