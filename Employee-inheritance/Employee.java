package p;

import java.util.Date;			//to use Date

public class Employee {
	private String name;
	private String number;
	private Date hireDate;
	private Address address;
	private boolean validEmployee;

	
	//constructors
	public Employee() {
		this.hireDate = new Date();
		validEmployee = true;
		errors();
	}

	public Employee(String name, String number, Address address) {
		this.name = name.replaceAll("[^a-zA-Z ]", "");		//if the name contains special characters, it will remove
		this.number = number;
		this.hireDate = new Date();
		this.address = address;
		validEmployee = true;
		errors();											//to update values if there is an error
	}
	
	public Employee(String name, String number, Date hireDate, Address address) {
		this.name = name.replaceAll("[^a-zA-Z ]", "");		//if the name contains special characters, it will remove
		this.number = number;
		this.hireDate = hireDate;
		this.address = address;
		validEmployee = true;
		errors();											//to update values if there is an error
	}
	//end constructors

	public double getTotalSalary() {
		return 0;
	}
	
	
	//setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.replaceAll("[^a-zA-Z ]", "");
		errors();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
		errors();
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
		errors();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isValidEmployee() {
		return validEmployee;
	}

	public void setValidEmployee(boolean validEmployee) {
		this.validEmployee = validEmployee;
	}
	//end setters and getters

	
	
	//isEmpNumberValid() method to check if the employee number is valid or no
	public boolean isEmpNumberValid() {
		
		if ( (number.length() == 5) &&										//check if the number of characters equals 5
			 (Character.isDigit(number.charAt(0))) &&						//check if the first character is digit
			 (Character.isDigit(number.charAt(1))) &&						//check if the second character is digit
			 (Character.isDigit(number.charAt(2))) &&						//check if the third character is digit
			 (number.charAt(3) == '-') &&									//check if the fourth character is '-'
			 (number.charAt(4) >= 'A' && number.charAt(4) <= 'M' ) ) {		//check if the fifth character is a letter within the range A–M
			
				return true;
		}
		
		return false;
	}
	//end isEmpNumberValid() method
	
	
	
	//errors() method to replace wrong values with error messages if exist 
	private String hireDateStr;
	@SuppressWarnings("deprecation")
	private void errors() {
		
		//if the employee doesn't have name, error message will printed instead if nothing
		if (name.length() == 0) {
			name = "Name isn't available";
		}
		
		//if the number is invalid, it will print error message instead of the number
		if (isEmpNumberValid() == false) {
			number = "Number is invalid";
		}
		
		//if the hire date is in the future, it will print error message instead of the date
		Date now = new Date();
		if ((hireDate.getYear() > now.getYear()) || ((hireDate.getYear() == now.getYear()) && (hireDate.getMonth() > now.getMonth()) )) {
			hireDateStr = "Date is invalid";
		} else {
			hireDateStr = hireDate.getDate() + "-" + hireDate.getMonth() + "-" + (hireDate.getYear()+1900);
		}
		
		//if the employee doesn't have neither name nor valid number, he/she will recognize as nonemployee
		if ((name.length() == 0) && (isEmpNumberValid() == false)) {
			validEmployee = false;
		}
	}
	//end errors() method

	
	
	//Employee toString() method
	@Override
	public String toString() {
		errors();											//to apply any changes in values because of errors
		return "Employee Name: " + name +
				"\nEmployee Number: " + number +
				"\nHire Date: " + hireDateStr + 
				"\nAddress: " + address;
	}
	//end Employee toString() method

}
