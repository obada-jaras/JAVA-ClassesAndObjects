/*
 * Name: Obada Tahayna
 * ID: 1191319
 * Lab Section: 12L
 */

package p;

import java.util.ArrayList;
import java.util.Date;


public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new ProductionWorker("Obada %", "120-A", new Date(117, 1, 11), new Address("Al Ersal st", "Palestine", "Ramallah", "7 7JN"), 1, 9, 230));
		employees.add(new ShiftSupervisor("hh", "121-B", new Date(119, 2, 4), new Address("Manarah st", "Palestine", "Nablus", "E6 2JT"), 1110, 120, 33, 20));
		employees.add(new TeamLeader("Mahammad S", "122-C", new Date(120, 3, 6), new Address("Darna st", "", "Jenin", "WV13 1EG"), 2, 10, 270, 120, 40, 42));
		employees.add(new ProductionWorker("Rami R", "126-A", new Date(114, 1, 14), new Address("Aspen Court st", "Guyana", "Ashtead", "KT21 2JS"), 4, 9, 192));
		employees.add(new ShiftSupervisor("Renad T", "125-B", new Date(116, 2, 28), new Address("Route 9 st", "Georgia", "Hunworth", ""), 1200, 170, 17, 30));
		employees.add(new TeamLeader("Lana O", "1242C", new Date(118, 8, 18), new Address("Cemetery Road", "Latvia", "London", "DE32 2NS"), 1, 11, 210, 100, -4, 31));
		
		
//		for(Employee i: employees) {
//			System.out.println(i + "\n\n\n");
//		}
	
		
		ListGreaterThanAverage(employees);		//calling the method that print the employees greater than average
	
	}
	
	
	
	public static void ListGreaterThanAverage(ArrayList<Employee> list) {
		double sum=0;
		int numberOfValidEmp = 0;			//number of valid employees is different from the list size, because the list contains  each valid and invalid employees
		
		//for loop to find the sum of valid employees salaries
		for (Employee i: list) {
			
			if (i.isValidEmployee()) {
				
				if (i instanceof ProductionWorker) {
					sum += ((ProductionWorker)i).getTotalSalary();	//casting from Employee to ProductionWorker if the employee is ProductionWorker, then add the salary to sum
					numberOfValidEmp++;

				} else if (i instanceof ShiftSupervisor) {
					sum += ((ShiftSupervisor)i).getTotalSalary();	//casting from Employee to ShiftSupervisor if the employee is ShiftSupervisor, then add the salary to sum
					numberOfValidEmp++;

				} else if (i instanceof TeamLeader){
					sum += ((TeamLeader)i).getTotalSalary();		//casting from Employee to TeamLeader if the employee is TeamLeader, then add the salary to sum
					numberOfValidEmp++;

				}
				
			}
		}
		//end of for loop
		double avg = sum/numberOfValidEmp;		//find the average
		
		
		//print information about employees with higher than average salary
		double totalSalary;
		for (Employee i: list) {
			
			if (i.isValidEmployee()) {

				if (i instanceof ProductionWorker) {
					totalSalary = ((ProductionWorker)i).getTotalSalary();	//casting from Employee to ShiftSupervisor if the employee is ShiftSupervisor
				
				} else if (i instanceof ShiftSupervisor) {
					totalSalary = ((ShiftSupervisor)i).getTotalSalary();	//casting from Employee to ShiftSupervisor if the employee is ShiftSupervisor
				
				} else if (i instanceof TeamLeader){
					totalSalary = ((TeamLeader)i).getTotalSalary();			//casting from Employee to TeamLeader if the employee is TeamLeader
				
				} else {
					totalSalary = 0;
					
				}
				

				if (totalSalary > avg) {					//print employee information if the salary is greater than the average
					System.out.println(i + "\n\n\n");
				}
			}
		}
		//
		
	}
	
}

