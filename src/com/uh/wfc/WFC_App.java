package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WFC_App {
	
	public static List<String> bookingDetailsList;
	public static List<String> timeTableList;
	public static List<List<String>> modifiedLists;
	
	

	public static void main(String[] args) {
		System.out.println("############################################");
		System.out.println("\tWeekend Fitness Club");
		
		// the main functionalities 
		System.out.println("############################################");
		System.out.println("1 - Book a Fitness Session ");
		System.out.println("2 - Change / Cancel a Session ");
		System.out.println("3 - Attend Fitness Lesson");
		System.out.println("4 - Monthly Lession Report ");
		System.out.println("5 - Monthly Champion Fitness Report ");
		System.out.println("6 - Exit System");
		System.out.println("---------------------------------------------");
		
		System.out.println("Choose the operation to perform ");
		System.out.println("Enter Operation ID:");
		// read the operation to perform  
		Scanner operation = new Scanner(System.in);
		BookingInfo bi = new BookingInfo();
		TimeTable tt = new TimeTable();
		Customer cs = new Customer();
		GroupSession gs = new GroupSession();
		Modify mod = new Modify();
		MonthlyReport monRep = new MonthlyReport();
		MonthlyChampionReport monChamRep = new MonthlyChampionReport();
		Attend attend = new Attend();
		
		 bookingDetailsList=bi.custDeatils() ;
		timeTableList= tt.fitnessSchedule();
		modifiedLists = new ArrayList<List<String>>();
		
		int option =operation.nextInt();
		while (option!=6) {
			
			switch (option) {
			case 1: 
				System.out.println("call the book a group session funciton or class");
				System.out.println("Enter you customer ID: (Sample input: cust01,cust02,cust03....cust16");
				String custID = operation.next();
				boolean isCustomerValid = cs.validateCustomer(custID);
				while(!isCustomerValid) {
					System.out.println("You have entered wrong customerID\n"
							+ "Enter Valid Customer ID:");
					custID  = operation.next();
					isCustomerValid = cs.validateCustomer(custID);
				}
				
				
				modifiedLists = gs.bookASession(timeTableList,bookingDetailsList, custID);
				
				if(modifiedLists==null) {
					break; 
				}
				 
				System.out.println("Validating time table in case--->>>");
				timeTableList = modifiedLists.get(0);
				bookingDetailsList =modifiedLists.get(1);
				System.out.println("Booking Successful...!!!");
				
				break;
			case 2: 
				
				System.out.println("1-Change Booking \n2-Cancel booking\n"
						+ "Choose option to perform");
				int op = operation.nextInt();
				if(op==1) {
					
					
					modifiedLists = mod.changeBooking(timeTableList,bookingDetailsList);
					
				}
				else if(op==2) {
					modifiedLists=mod.cancelBooking(timeTableList,bookingDetailsList);
				}	 
				if(modifiedLists==null) { break; }
				else {
						
						timeTableList = modifiedLists.get(0);
						bookingDetailsList =modifiedLists.get(1);
						
						if(op==1) {
							System.out.println("Change class is Successful...!!!");
						}
						if(op==2) {
							System.out.println("Cancellation Successful...!!!");
						}
						
				}
				
				break;
			case 3: 
				bookingDetailsList = attend.attendASession(bookingDetailsList);
				break;
			case 4: 
				
				  System.out.println("enter month  (range between: 1 to 12)"); 
				  int month = operation.nextInt(); 
				  while (month < 1 || month > 12) {
					  System.out.println("enter valid month (range between: 1 to 12)"); 
					  month = operation.nextInt(); 
				  }
				 
				monRep.monthLessonReport(bookingDetailsList,month);
				break;
			case 5: 
				
				System.out.println("enter month(range between: 1 to 12)"); 
				   month = operation.nextInt(); 
				  while (month < 1 || month > 12) {
					  System.out.println("enter valid month (range between: 1 to 12)"); 
					  month = operation.nextInt(); 
				  }
				   bookingDetailsList = bi.custDeatils();
				monChamRep.monthChampionReport( bookingDetailsList,month);
				break;
			case 6: System.out.println("exit system");
			break;
			}
			
			if (option!=6) {
				System.out.println("\n\n############################################");
				System.out.println("\t\tMain menu");
				System.out.println("############################################");
				System.out.println("1 - Book a Fitness Session ");
				System.out.println("2 - Change / Cancel a Session ");
				System.out.println("3 - Attend Fitness Lesson");
				System.out.println("4 - Monthly Lession Report ");
				System.out.println("5 - Monthly Champion Fitness Report ");
				System.out.println("6 - Exit System");
				System.out.println("---------------------------------------------");
				
				System.out.println(" Choose the operation to perform ");
				option =operation.nextInt();
			}
		
	}
System.out.println("Thanks for using Weekend Fitness Club booking System... Exited Sucessfully!!!");
	}

}
