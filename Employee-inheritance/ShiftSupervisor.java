package p;

import java.util.Date;

public class ShiftSupervisor extends Employee {
	private double monthlySalary;				//monthly fixed salary
	private double monthlyBonus;				//Monthly production bonus that a shift supervisor has earned
	private int numberOfProducedProducts;		//Number of products that produced by team that he/she supervised.
	private int numberOfProductsMustProduced;	//Number of products must produced under his/her supervision.
	
	
	//constructors
	public ShiftSupervisor() {
		errors();
	}
	
	public ShiftSupervisor(String name, String number, Date hireDate, Address address,
							double monthlySalary, double monthlyBonus,
							int numberOfProducedProducts, int numberOfProductsMustProduced) {
		
		super(name, number, hireDate, address);
		this.monthlySalary = monthlySalary;
		this.monthlyBonus = monthlyBonus;
		this.numberOfProducedProducts = numberOfProducedProducts;
		this.numberOfProductsMustProduced = numberOfProductsMustProduced;
		errors();
	}
	//end constructors

	
	//setters and getters
	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
		errors();
	}

	public double getMonthlyBonus() {
		return monthlyBonus;
	}

	public void setMonthlyBonus(double monthlyBonus) {
		this.monthlyBonus = monthlyBonus;
		errors();
	}

	public int getNumberOfProducedProducts() {
		return numberOfProducedProducts;
	}

	public void setNumberOfProducedProducts(int numberOfProducedProducts) {
		this.numberOfProducedProducts = numberOfProducedProducts;
		errors();
	}

	public int getNumberOfProductsMustProduced() {
		return numberOfProductsMustProduced;
	}

	public void setNumberOfProductsMustProduced(int numberOfProductsMustProduced) {
		this.numberOfProductsMustProduced = numberOfProductsMustProduced;
		errors();
	}
	//end setters and getters

	
	
	//total salary for Shift Supervisor
	private String monthlySalaryStr, monthlyBonusStr, numberOfProducedProductsStr, numberOfProductsMustProducedStr;
	public double getTotalSalary() {
		
		monthlySalaryStr = monthlySalary + "";
		monthlyBonusStr = monthlyBonus + "";
		numberOfProducedProductsStr = numberOfProducedProducts + "";
		numberOfProductsMustProducedStr = numberOfProductsMustProduced + "";
		
		
		//if the employee produced products more than required, he/she get a bonus with his/her fixed salary
		if (numberOfProducedProducts >= numberOfProductsMustProduced) {
			return monthlySalary + monthlyBonus;
		}
		
		//if he/she didn't produce products more than required, he/she get just the fixed monthly salary
		else {
			return monthlySalary;
		}
	}
	//end total salary for Shift Supervisor

	
	
	//errors() method to replace wrong values with error messages if exist 
	private double totalSalary;
	private void errors() {
		
		//if there is any error with the inputs that affect on the salary, there is an error and the employee will mark as nonemployee
		if ((monthlySalary <= 0) || (monthlyBonus <= 0) || (numberOfProducedProducts <= 0) || (numberOfProductsMustProduced <= 0)) {
			super.setValidEmployee(false);
			totalSalary = 0;


			//replace the value of monthlySalaryStr with  error message if the hourly pay rate is zero or in minus
			if (monthlySalary <= 0) {
				monthlySalaryStr = "Error in monthly salary";
			}
			
			//replace the value of monthlyBonusStr with  error message if the monthlyHours is zero or in minus
			if (monthlyBonus <= 0) {
				monthlyBonusStr = "Error in monthly bonus";
			}		
			
			//replace the value of numberOfProducedProductsStr with  error message if the monthlyHours is zero or in minus
			if (numberOfProducedProducts <= 0) {
				numberOfProducedProductsStr = "Error in number of produced products";
			}		
			
			//replace the value of numberOfProductsMustProducedStr with  error message if the monthlyHours is zero or in minus
			if (numberOfProductsMustProduced <= 0) {
				numberOfProductsMustProducedStr = "Error in number of products must produced";
			}		
		}
		
		else {
			totalSalary = getTotalSalary();
		}
		
	}
	//end errors() method
		
	
	
	//ShiftSupervisor toString() method	
	@Override
	public String toString() {
		errors();											//to apply any changes in values because of errors
		return super.toString() + "\nEmployee Type: Shift Supervisor" +
			"\nMonthly Salary: " + monthlySalaryStr +
			"\nMonthly Production Bonus: " + monthlyBonusStr +
			"\nNumber of Products Produced by Supervisor Team: " + numberOfProducedProductsStr +
			"\nNumber of Products Must Produced by Supervisor Team: " + numberOfProductsMustProducedStr +
			"\nTotal Salary: " + totalSalary;
	}
	//end ShiftSupervisor toString() method

	
}
