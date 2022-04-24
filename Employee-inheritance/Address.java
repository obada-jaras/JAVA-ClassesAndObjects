package p;

public class Address {
	private String street;
	private String state;
	private String city;
	private String zipCode;

	
	//constructors
	public Address() {
		erros();
	}

	public Address(String street, String state, String city, String zipCode) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		erros();
	}
	//end constructors


	//setters and getters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
		erros();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		erros();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		erros();
	}

	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
		erros();
	}
	//end setters and getters

	
	
	//errors() method displays that the value isn't available if it's not exist
	private void erros() {
		if (street.length() == 0) 
			street = "Street name isn't available";
		
		if (state.length() == 0) 
			state = "State name isn't available";
		
		if (city.length() == 0) 
			city = "City name isn't available";
		
		if (zipCode.length() == 0) 
			zipCode = "ZIP Code isn't available";
	}
	//end errors() method
	
	
	
	//address toString
	@Override
	public String toString() {
		erros();											//to apply any changes in values because of errors
		return "(Street: " + street + ", State: " + state + ", City: " + city + ", ZIP Code: " + zipCode + ")";
	}
	//end address toString
	
}
