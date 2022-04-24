
public class Car extends Vehicle {
	private int numberOfSeats;
	private boolean airConditionOn;
	
	
	
	
	//constructors
	public Car() {
		this.airConditionOn = false;		//default air condition status is off
	}
	

	public Car(String modelName, String modelNo, String brand, int engineType, double tunkSize, 
			double fuelConsumption, Owner owner, int numberOfSeats) {
		
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		
		if (engineType == PetroleumType.GASOLINE || engineType == 3) {	//check if mismatch filling type of Petroleum
			this.numberOfSeats = numberOfSeats;
			this.airConditionOn = false;		//default air condition status is off
		
		} else 	//throw exception if mismatch filling type of Petroleum
			throw new IllegalArgumentException("Cars engine can only be Gasoline or Hybrid");
		
	}
	//end constructors
	
	
	
	
	//setters and getters
	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public boolean isAirConditionOn() {
		return airConditionOn;
	}


	public void setAirConditionOn(boolean airConditionOn) {
		this.airConditionOn = airConditionOn;
	}
	//**end setters and getters
	
	
	

	//costFor100Km() method calculating cost for running 100Kms with the engine type and the petroleum type. It will be different according to fuel and air-condition's status
	//in the project description and UML, this method should have a PetroleumType parameter, but a make it in a way better by make the gasoline and diesel prices in
	//the class PetroleumType static, so there is no meaning if I pass the parameter :) 
	@Override
	public double costFor100Km() {
		double liters = 100 / super.fuelConsumption;		//number of letters cost by running 100km 
		double cost = liters * PetroleumType.getGasolinePrice();	//the NIS cost of running 100km in the default status (air condition is off)
		
		if (airConditionOn) 
			return cost*1.1;
			
		else 
			return cost;
		
		
		
		
		/* Fuel Consumption is the inverse of fuel economy. It is the amount of fuel consumed in driving a given distance. (Assessment of Fuel Economy 
		 * Technologies for Light-Duty Vehicles (2011), Chapter: 2 Fundamentals of Fuel Consumption)
		 * In our project, fuel consumption unit specified as km/liter, but really the unit of fuel consumption is liter/km
		 * On the other hand, the example of how the input file look, the values of fuel consumption cannot be liter/km, you certainly mean fuel economy with unit
		 * km/liter. 
		 * and in costFor100Km method description, its written that Fuel consumption of the Car increased by 10% when air-condition of the Car is ON
		 * but really that cannot be if we consider fuel consumption unit as km/liter. So I increased the cost by 10% :)
		 */
		 
		
		/* In the UML code for the project, the costFor100Km() method should have a parameter from PetroleumType type, but I worked my code in a
		 * way better and doesn't need to pass a parameter; so I didn't pass it 
		 */

	}

	
	
	
	//setAirConditionON() method changes the value of variable airConditionOn to true if its false, and display a message to confirm that
	//but if its already on, it will just display a message  tell the user
	@Override
	public void setAirConditionON() {
		if (airConditionOn) 
			System.out.println("The air condition of car selected is already ON");
		
		else {
			airConditionOn = true;
			System.out.println("The air condition of car selected turned ON");
		}
		
	}
	
	
	//setAirConditionOFF() method changes the value of variable airConditionOn to false if its true, and display a message to confirm that
	//but if its already off, it will just display a message tell the user
	@Override
	public void setAirConditionOFF() {
		if (!airConditionOn) 
			System.out.println("The air condition of car selected is already OFF");
		
		else {
			airConditionOn = false;
			System.out.println("The air condition of car selected turned OFF");
		}
	}


	
	//override toString method to print cars data
	@Override
	public String toString() {
		return "Car " + super.toString() + ", Number Of Seats: " + numberOfSeats;
	}

	

	//shortToString() return just that this object is a car with some of vehicle info
	@Override
	public String shortToString() {
		return "Car " + super.toString();
	}

	
}
