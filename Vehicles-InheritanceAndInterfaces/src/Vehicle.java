public abstract class Vehicle implements Cloneable {
	protected String modelName;
	protected String modelNo;
	protected String brand;
	protected int engineType;		// In UML code, this variable should be string, but in my project I worked it in a way better that scan a string and store it as int
	protected double tunkSize;
	protected double fuelConsumption;
	public Owner owner;
	
	
	//constructors 
	public Vehicle() {
	}
	
	public Vehicle(String modelName, String modelNo, String brand, int engineType, double tunkSize,
			double fuelConsumption, Owner owner) {
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.brand = brand;
		this.engineType = engineType;
		this.tunkSize = tunkSize;
		this.fuelConsumption = fuelConsumption;
		this.owner = owner;
	}
	//**end constructors
	
	
	
	
	//setters and getters
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getEngineType() {
		return engineType;
	}

	public void setEngineType(int engineType) {
		this.engineType = engineType;
	}

	public double getTunkSize() {
		return tunkSize;
	}

	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	//**end setters and getters
	
	
	
	//abstract methods
	public abstract double costFor100Km();
	public abstract void setAirConditionON();
	public abstract void setAirConditionOFF();
	//**end abstract methods
	
	
	
	//movableDistance() method getting information of movable distance of a vehicle when the tank of the vehicle is filled fully
	public double movableDistance() {
		return tunkSize*fuelConsumption;
	}


	

	//override toString method to print vehicles data
	@Override
	public String toString() {
		//to print the engine type as a string not integer
		String engineTypeStr = (engineType == PetroleumType.DIESEL)? "Diesel" :
								(engineType == PetroleumType.GASOLINE)? "Gasoline" :
								(engineType == 3)? "Hybrid" : "";
		
		
		return "|| ModelName: " + modelName + ", ModelNo: " + modelNo + ", Brand: " + brand + ", EngineType: "
				+ engineTypeStr + ", TunkSize: " + tunkSize + "Liter, FuelConsumption: " + fuelConsumption + "Km/Liter, Movable Distance: "
				+ movableDistance() + "Km, Cost for 100Km: " + String.format("%.2f", costFor100Km()) + "NIS, Owner:" + owner;
	}

	
	
	
	//override toString method to print short data about the vehicle
	public String shortToString() {
		//to print the engine type as a string not integer
		String engineTypeStr = (engineType == PetroleumType.DIESEL)? "Diesel" :
			(engineType == PetroleumType.GASOLINE)? "Gasoline" :
			(engineType == 3)? "Hybrid" : "";
		
		
		return "|| Brand: " + brand + ", EngineType: " + engineTypeStr + ", FuelConsumption: " + fuelConsumption 
				+ "Km/Liter, Cost for 100Km: " + String.format("%.2f", costFor100Km()) + "NIS, Owner" + owner.getName();
	}

	
	
	//override the clone method to clone objects
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicle v = (Vehicle)super.clone();
		v.setOwner((Owner) owner.clone());		//to make it deep cloning by clone the owner too
		return v;
	}
	
}
