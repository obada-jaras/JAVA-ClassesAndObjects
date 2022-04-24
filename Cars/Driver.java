import java.util.Date;						//import Date library
import java.util.Scanner;					//import Scanner library


public class Driver {
	
	
	//define Date to get current year and month
	static Date dt = new Date();
	static int currentYear = dt.getYear()+1900;		//getYear() method return number of years after the year 1900 
	static int currentMonth = dt.getMonth()+1;		//getMonth() method return the month -1 
	//
	
	
	//main method
	public static void main(String[] args) {
		Car[] cars = new Car[5];			//call Car method
		
		//initialize 5 cars values
		cars[0] = new Car("0124-A", 2017, 10, "Yellow", 180000.0, "Mercedes", 1888, 17);
		cars[1] = new Car("0128-A", 1800, 15, "Black", 0, "BMW", 2051, 9);
		cars[2] = new Car();
		cars[3] = new Car("0124-A", 2020, 12, "Gray", 210000.0, "BMW", 2024, 0);
		cars[4] = new Car("0127-B", 2020, -1, "Black", 85000.0, "Nissan", 2019, 10);
		//
		
		
		//determine which output the system will print
		int selection = 0;
		Scanner in = new Scanner(System.in);
		
		while (selection != -1) {			//while loop to keep the program run until the user enter -1
			String print =    "# # # # # # # # # # # # # # # # # # # # # # # # # #\n"
							+ "#   Enter number of task you want                 #\n"
							+ "#   1) Print all cars info.                       #\n"
							+ "#   2) Print the info of the greatest car price.  #\n"
							+ "#   Enter -1 to end                               #\n"
							+ "# # # # # # # # # # # # # # # # # # # # # # # # # #";
			System.out.println(print.toUpperCase());
			selection = in.nextInt();
			Car max = maxPrice(cars);
			
			switch (selection) {
				case 1: printCarsInfo(cars); break;
				case 2: System.out.println(("The info of max price car:\n" +max.printCarInfo() +"\n" +max.getCarAge() +"\n" +max.getCalculateGuarantee()+ "\n\n\n").toUpperCase()); break;
				case -1: System.out.println("END"); System.exit(1);
				default: System.out.println("Please enter 1 or 2 (or -1 to exit)".toUpperCase()); break;
			}
		}
		in.close();
		//
	}
	//
	
	
	//printCarsInfo method that prints all the car data with car ages and guarantee due to
	public static void printCarsInfo(Car[] cars) {
		String info;
		
		//for loop to print the info of all cars in array
		for (int i = 0; i < cars.length; i++) {
			info = cars[i].printCarInfo() +"\n" +cars[i].getCarAge() +"\n" +cars[i].getCalculateGuarantee();
			System.out.println(info.toUpperCase() +"\n\n\n");
		}
		//
	}
	//
	
	
	//maxPrice method that return the object of car with the highest price
	public static Car maxPrice(Car[] cars) {
		double maxPrice = cars[0].getPrice();
		int index = 0;
		
		//for loop to let the system compare maxPrice variable with the price of every car in the array
		for (int i = 1; i < cars.length; i++) {
			if (cars[i].getPrice() > maxPrice) {
				maxPrice = cars[i].getPrice();
				index = i;					//to return cars[index]
			}
		}
		//
		
		return cars[index];
	}
	//
	
}