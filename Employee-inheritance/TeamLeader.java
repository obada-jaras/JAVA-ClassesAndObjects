package p;

import java.util.Date;

public class TeamLeader extends ProductionWorker {
	private double monthlyBonus;
	private int requiredTrainingHours;
	private int trainingHoursAttended;
	
	
	//constructors
	public TeamLeader() {
		errors();
	}
	
	public TeamLeader(String name, String number, Date hireDate, Address address,
						int shift, double rate, int monthlyHours,
						double monthlyBonus, int requiredTrainingHours, int trainingHoursAttended) {
		
		super(name, number, hireDate, address, shift, rate, monthlyHours);
		this.monthlyBonus = monthlyBonus;
		this.requiredTrainingHours = requiredTrainingHours;
		this.trainingHoursAttended = trainingHoursAttended;
		errors();
	}
	//end constructors

	
	//setters and getters
	public double getMonthlyBonus() {
		return monthlyBonus;
	}

	public void setMonthlyBonus(double monthlyBonus) {
		this.monthlyBonus = monthlyBonus;
		errors();
	}

	public int getRequiredTrainingHours() {
		return requiredTrainingHours;
	}

	public void setRequiredTrainingHours(int requiredTrainingHours) {
		this.requiredTrainingHours = requiredTrainingHours;
		errors();
	}

	public int getTrainingHoursAttended() {
		return trainingHoursAttended;
	}

	public void setTrainingHoursAttended(int trainingHoursAttended) {
		this.trainingHoursAttended = trainingHoursAttended;
		errors();
	}
	//end setters and getters

	
	//total salary for Shift Supervisor
	private String monthlyBonusStr, requiredTrainingHoursStr, trainingHoursAttendedStr;
	public double getTotalSalary() {
		monthlyBonusStr = monthlyBonus + "";
		requiredTrainingHoursStr = requiredTrainingHours + "";
		trainingHoursAttendedStr = trainingHoursAttended + "";
		
		if (trainingHoursAttended >= requiredTrainingHours) {		//"Team leaders are required to attend a minimum number of hours of training per month"
			return super.getTotalSalary() + (monthlyBonus * trainingHoursAttended / requiredTrainingHours);
		
		} else {
			return super.getTotalSalary();

		}
	}
	//end total salary for Shift Supervisor

	
	
	
	
	//errors() method to replace wrong values with error messages if exist 
	private void errors() {
		
		//if there is any error with the inputs that affect on the salary, there is an error and the employee will mark as nonemployee
		if ((monthlyBonus <= 0) || (requiredTrainingHours <= 0) || (trainingHoursAttended <= 0)) {
			super.setValidEmployee(false);
			super.totalSalary = 0;	
			
			
			//replace the value of monthlyBonusStr with  error message if the monthlyHours is zero or in minus
			if (monthlyBonus <= 0) {
				monthlyBonusStr = "Error in monthly bonus";
			}		
			
			//replace the value of numberOfProducedProductsStr with  error message if the monthlyHours is zero or in minus
			if (requiredTrainingHours <= 0) {
				requiredTrainingHoursStr = "Error in required training hours";
			}		
			
			//replace the value of numberOfProductsMustProducedStr with  error message if the monthlyHours is zero or in minus
			if (trainingHoursAttended <= 0) {
				trainingHoursAttendedStr = "Error in training hours attended";
			}
		}
		
		else {
			super.totalSalary = getTotalSalary();
		}
		
	}
	//end errors() method
	
	
		
	//TeamLeader toString() method
	@Override
	public String toString() {
		errors();											//to apply any changes in values because of errors
		return super.toString() + "\nProduction Worker Type: Team Leader" +
				"\nMonthly Bonus: " + monthlyBonusStr +
				"\nRequired Training Hours: " + requiredTrainingHoursStr +
				"\nTraining Hours Attended: " + trainingHoursAttendedStr;
	}
	//end TeamLeader toString() method


}
