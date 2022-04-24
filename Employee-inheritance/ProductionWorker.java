package p;

import java.util.Date;

public class ProductionWorker extends Employee {
	private int shift;				//1: day | 2: night
	private double rate;			//hourly pay rate
	private int monthlyHours;		//per month
	
	
	//constructors
	public ProductionWorker() {
		errors();		//to update values if there is an error
	}
	
	public ProductionWorker(String name, String number, Date hireDate, Address address, int shift, double rate, int monthlyHours) {
		super(name, number, hireDate, address);
		this.shift = shift;
		this.rate = rate;
		this.monthlyHours = monthlyHours;
		errors();		//to update values if there is an error
	}
	//end constructors


	//setters and getters
	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
		errors();
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
		errors();
	}

	public int getMonthlyHours() {
		return monthlyHours;
	}

	public void setMonthlyHours(int monthlyHours) {
		this.monthlyHours = monthlyHours;
		errors();
	}
	//end setters and getters

	

	//total salary for Production Worker
	private String shiftStr, rateStr, monthlyHoursStr;
	public double getTotalSalary() {
		
		rateStr = rate + "";
		monthlyHoursStr = monthlyHours + "";
		
		final int workDays = 26;	//number of working day per month
		int minimumDailyHours;		//minimum hours to work per day, if worker works less than it, he/she will not take salary
		double extra;				//for extra hours
		
		if (shift == 1) {			//day shift
			minimumDailyHours = 8;
			extra = 1.25;
			shiftStr = "Day Shift";
		
		} else if (shift == 2) {	//night shift
			minimumDailyHours = 7;
			extra = 1.5;
			shiftStr = "Night Shift";
		
		} else {
			return 0;
		
		}
		
		
		int minimumMonthlyHours = minimumDailyHours * workDays;			//minimum hours to work per month, if worker works less than it, he/she will not take salary
		double AverageDailyHours = monthlyHours/workDays;				//the average of hours worked per day

		if (AverageDailyHours >= minimumDailyHours) {
			return (extra*monthlyHours + (1-extra)*minimumMonthlyHours) * rate;
			//this equation equivalent to : minimumMonthlyHours*rate +  (monthlyHours-minimumMonthlyHours)*extra*rate
		}
		
		 
		return 0;				//if the worker doens't work at least 8 hours, the salary will be zero because the worker must work at least 8 hours per day
	
	/*note: in my program, I compare if the average of daily hours is greater than the minimum hours required 
	 * but really this is wrong, because the worker may works 15 hours in some days, and 1 hour in another days
	 * and the average is below the minimum hours required; so the worker will not take any money
	 * but in fact he/she should paid for the days he/she worked above the required hours
	 * 
	 * SOLUTION: when our program become for a company as example, it will store the number of hours everyday, so we will not face this problem
	*/
	}
	//end total salary for Production Worker

	
	
	//errors() method to replace wrong values with error messages if exist 
	protected double totalSalary;
	private void errors() {
		
		//if the hourly pay rate is zero or in minus, it will be an error add the employee will define as nonemployee
		//if the monthlyHours is zero or in minus, it will be an error and the employee will define as nonemployee
		//if the shift is neither 1 nor zero, it will be an error and the employee will define as nonemployee
		if ((rate <= 0) || (monthlyHours <= 0) || (shift != 1 && shift != 2)) {
			super.setValidEmployee(false);
			totalSalary = 0;

			//replace the value of rateStr with  error message if the hourly pay rate is zero or in minus
			if (rate <= 0) {
				rateStr = "Error in rate";
			}
			
			//replace the value of monthlyHoursStr with  error message if the monthlyHours is zero or in minus
			if (monthlyHours <= 0) {
				monthlyHoursStr = "Error in monthly hours";
			}
			
			//replace the value of shiftStr with  error message if the shift is neither 1 nor zero
			if ((shift != 1) && (shift != 2)) {
				shiftStr = "Error, neither day shift nor night shift";
			}
		}
		
		
		else {
			totalSalary = getTotalSalary();
		}
		
	}
	//end errors() method
	
	
	//ProductionWorker toString() method
	@Override
	public String toString() {
		errors();											//to apply any changes in values because of errors
		return super.toString() + "\nEmployee Type: Production Worker" +
				"\nShift: " + shiftStr +
				"\nHourly Pay Rate: " + rateStr +
				"\nNumber of Hours per Month: " + monthlyHoursStr +
				"\nTotal Salary: " + totalSalary;
	}
	//end ProductionWorker toString() method
	
	
}
