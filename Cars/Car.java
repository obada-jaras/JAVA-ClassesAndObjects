import java.util.Date;						//import Date library


public class Car {
	public String PlateNo;
	private int yearmanufacture;
	private int monthmanufacture;
	private String color;
	private double price;
	private String manufactureby;
	private int guaranteedueyear;
	private int guaranteeduemonth;
	
	
	//define Date to get current year and month
	Date dt = new Date();
	private int currentYear = dt.getYear()+1900;		//getYear() method return number of years after the year 1900 
	private int currentMonth = dt.getMonth()+1;			//getMonth() method return the month - 1
	//
	
	
	//give default values for car data
	public Car() {
		PlateNo = "0123-A";
		yearmanufacture = currentYear;
		monthmanufacture = currentMonth;
		color = "red";
		price = 50000.00;
		manufactureby = "Mercedes";
		
		//if statement to avoid get month number more than 12
		if (currentMonth > 6) {
			guaranteedueyear = currentYear+1;
			guaranteeduemonth = currentMonth-6;
		} else {						//
			guaranteedueyear = currentYear;
			guaranteeduemonth = currentMonth+6;
		}
		//
		
	}
	
	
	//give the car values from parameters
	public Car(String PlateNo, int yearmanufacture, int monthmanufacture, String color, double price, String manufactureby,  int guaranteedueyear, int guaranteeduemonth) {
		this.PlateNo = PlateNo;
		this.yearmanufacture = yearmanufacture;
		this.monthmanufacture = monthmanufacture;
		this.color = color;
		this.price = price;
		this.manufactureby = manufactureby;
		this.guaranteedueyear = guaranteedueyear;
		this.guaranteeduemonth = guaranteeduemonth;
	}
	//
	
	
	//plate number getter to use it in error message
	public String getPlateNo() {
		return PlateNo;
	}
	//
	
	
	//year manufacture getter
	public int getYearManufacture() {
		return yearmanufacture;
	}
	//
	
	
	//month manufacture getter
	public int getMonthManufacture() {
		return monthmanufacture;
	}
	//
	
	
	//color getter
	public String getColor() {
		return color;
	}
	//
	
	
	//price getter
	public double getPrice() {
		return price;
	}
	//
	
	
	//year manufacture setter
	public void setYearManufacture(int year) {
		yearmanufacture = year;
	}
	//
	
	
	//month manufacture setter
	public void setMonthManufacture(int month) {
		monthmanufacture = month;
	}
	//
	
	
	//color setter
	public void setColor(String color) {
		this.color = color;
	}
	//
	
	
	//guarantee year and month setter
	public void setGuarantee(int month, int year) {
		guaranteedueyear = year;
		guaranteeduemonth = month;
	}
	//
	
	
	//calculate the age of car
	public String getCarAge() {
		int years, months;
		String yearsStr, andStr="", monthsStr, Age;
		
		//to avoid minus in months
		if (currentMonth >= monthmanufacture) {
			years = currentYear - yearmanufacture;
			months = currentMonth - monthmanufacture;
		} else {
			years = currentYear - yearmanufacture -1;
			months = (12 + currentMonth - monthmanufacture);
		}
		//
		
		
		//print s when "years" plural, and without s when singular, and doesn't print anything when 0 
		if (years == 0)
			yearsStr = "";
		else if (years == 1)
			yearsStr = years +" year ";
		else 
			yearsStr = years +" years ";
		//
		
		
		//if there are years and months, we put "and" between them, else we doesn't print "and"
		if (years != 0 && months != 0)
			andStr = "and ";
		//if the car manufactured in the same month of the current year, the out put will be as follow
		else if (years == 0 && months == 0)
			andStr = "The car has just been manufactured";
		//
			
		
		//print s when "months" plural, and without s when singular, and doesn't print anything when 0 
		if (months == 0)
			monthsStr = "";
		else if (months == 1)
			monthsStr = months +" month";
		else 
			monthsStr = months +" months";
		//
		
		
		//return error if the year manufactured less than 1886 (The year that the first car manufactured in) or the month less than 1 or more than 13
		if (yearmanufacture < 1886 || monthmanufacture < 1 || monthmanufacture > 12) 
			Age = "Car age is: Error, invalid date entered";
		//return error if the values entered refers to the future
		else if (years < 0 || (years == 0 && months < 0))
			Age = "Car age is: Error, car cannot manuafcture in the future";
		//if it refers to the past then return the age of the car
		else
			Age = "Car age is: " +yearsStr +andStr +monthsStr;
		//
		
		return Age;
	}
	//
	
	
	//print all info about the car
	public String printCarInfo() {
		String info = "\nPlate No: " +PlateNo;
		
		//first car was manufactured in 1886, so if the year manufactured is before that year will be an invalid date
		if (yearmanufacture < 1886)
			info += "\nYear manufacture: Error, there is no cars manufactured before 1886"
					+"\nMonth manufacture: Error";
		
		//car cannot manufacture in the future
		else if (yearmanufacture > currentYear)
			info += "\nYear manufacture: Error, car cannot manufacture in the future"
					+"\nMonth manufacture: Error, car cannot manufacture in the future";
		
		//if yearmanufacture is the same as current year, but monthmanufacture is after the current month then it will be an invalid date
		else if (yearmanufacture == currentYear && monthmanufacture > currentMonth)
			info += "\nYear manufacture: " +yearmanufacture
					+"\nMonth manufacture: Error, car cannot manufacture in the future";
		
		//else no problem
		else {
			info += "\nYear manufacture: " +yearmanufacture;	
		
			//numbers less than 1 or more than 12 are invalid numbers for months
			if (monthmanufacture < 1)
				info += "\nMonth Manufacture: Error, month cannot be less than 1";
			else if  (monthmanufacture > 12)
				info += "\nMonth Manufacture: Error, month cannot be more than 12";
			else
				info += "\nMonth manufacture: " +monthmanufacture;
		}
		//
		
		
		//there is no errors with color
		info += "\ncolor: " +color;
		//
		
		
		//there is no cars have a price less than zero
		if (price < 0)
			info += "\nprice: Error, price cannot be less than 0";
		else
			info += "\nprice: " +price;
		//
		
		
		//there is no errors with manufacturer 
		info += "\nManufacture by: " +manufactureby;
		//
		
		
		//we suppose that there is no guarantees for more than 30 years
		if (guaranteedueyear > currentYear+30)
			info += "\nGuarantee due to year: Error, guarantee cannot be for more than 30 years from now"
					+"\nGuarantee due to month: Error";
		
		//there is no guarantee before 1886; because first car was manufactured in 1886
		else if (guaranteedueyear < 1886)
			info += "\nGuarantee due to year: Error"
					+"\nGuarantee due to month: Error";
		
		//else no problem
		else { 
			info += "\nGuarantee due to year: " +guaranteedueyear;
			
			//numbers less than 1 or more than 12 are invalid numbers for months
			if (guaranteeduemonth < 1)
				info += "\nGuarantee due to month: Error, month cannot be less than 1";
			else if (guaranteeduemonth > 12)
				info += "\nGuarantee due to month: Error, month cannot be more than 12";
			else
				info += "\nGuarantee due to month: " +guaranteeduemonth;
		}
		//	
			
		
		return info;
	}
	//
	
	
	//"manufacture by" getter
	public String getmanufactureby() {
		return manufactureby;
	}
	//
	
	
	//calculate the guarantee remain years and months
	public String getCalculateGuarantee() {
		int years, months;
		String yearsStr, andStr="", monthsStr, guaranteeRemain;
		
		//to avoid minus in months
		if (guaranteeduemonth >= currentMonth) {
			years = guaranteedueyear - currentYear;
			months = guaranteeduemonth - currentMonth;
		} else {
			years = guaranteedueyear - currentYear -1;
			months = (12 + guaranteeduemonth - currentMonth);
		}
		
		//print s when "years" plural, and without s when singular, and doesn't print anything when 0 
		if (years == 0)
			yearsStr = "";
		else if (years == 1)
			yearsStr = years +" year ";
		else 
			yearsStr = years +" years ";
		//
		
		
		//if there are years and months, we put "and" between them, else we doesn't print "and"
		if (years != 0 && months != 0)
			andStr = "and ";
		//
		
		
		//print s when "months" plural, and without s when singular, and doesn't print anything when 0 
		if (months == 0)
			monthsStr = "";
		else if (months == 1)
			monthsStr = months +" month";
		else 
			monthsStr = months +" months";
		//
		
		
		//we suppose that there is no guarantees for more than 30 years, and there is error if the month less than 1 or more than 13
		if (guaranteedueyear > currentYear+30 || guaranteeduemonth < 1 || guaranteeduemonth > 12) 
			guaranteeRemain = "Guarantee Remain: Error, invalid date entered";
		//if the guarantee date is in past, it will return that the guarantee expired
		else if (years < 0 || (years == 0 && months <= 0))
			guaranteeRemain = "Guarantee Remain: Car guarantee expired";
		//if the guarantee date is in the future then the system print the remain of it
		else
			guaranteeRemain = "Guarantee Remain: " +yearsStr +andStr +monthsStr;
		//
		
		return guaranteeRemain;
	}
	//
	
}