package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Modify {

	private List<String> timeTableMod, bookingDataMod;
	private List<List<String>> modifiedList = new ArrayList<>();
	public List<List<String>>  cancelBooking(List<String> timeTableList, List<String> bookingDetailsList) {
		
		Scanner sc = new Scanner(System.in);
		Customer cust = new Customer();
		GroupSession gs = new GroupSession();
		Modify modify = new Modify();
		System.out.println("Enter you customer ID: (Sample input: cust01,cust02...");
		String custID = sc.next();
		boolean isCustomerValid = cust.validateCustomer(custID);
		while(!isCustomerValid) {
			System.out.println("You have entered wrong customerID\n"
					+ "Enter Valid Customer ID:");
			custID  = sc.next();
			isCustomerValid = cust.validateCustomer(custID);
		}
		System.out.println("Availble bookings with this customer ID:"+custID);

		System.out.println("======================================================");
		System.out.println("BookingId\t Fitness \t Date\t\t Status");
		System.out.println("======================================================");
		
		int count=0;
		for(String data :bookingDetailsList) {
			if(data.split(",")[1].equals(custID)) {
				System.out.println(
						data.split(",")[0]+"\t\t"+
						data.split(",")[2]+"\t\t"+
						data.split(",")[4]+"\t"+		
						data.split(",")[5]
						);
			}
			if(data.split(",")[1].equals(custID)&& data.split(",")[5].equals("booked")) {
				count++;
			}
		}
		System.out.println("--------------------------------------------------------");
		if(count ==0) {
			System.out.println("You don't have any pending sessions to attend.. ");
			return null;
		}
		System.out.println("enter booking Id to cancel the session");
		String cancelId = sc.next();
		boolean flag = true;
		String bookInfo = "";
		for(String data :bookingDetailsList) {
			
			if(data.split(",")[0].equals(cancelId)&& data.split(",")[5].equals("booked")) {
				flag = false;
				bookInfo =data;
			}
		}
		if(flag) {
			System.out.println("Please choose class Id which is in booked status.. ");
			return null;
		}
		
		timeTableMod = gs.updateTimetable(timeTableList, Integer.valueOf(bookInfo.split(",")[10]), -Integer.valueOf(bookInfo.split(",")[7]));
		bookingDataMod = modify.updateStatus(bookingDetailsList, cancelId,"cancelled");
		
		modifiedList.clear();
		modifiedList.add(timeTableMod);
		modifiedList.add(bookingDataMod);
		return modifiedList;
		
	}


	public List<String> updateStatus(List<String> bookingDetails,String bookingId,String status){
		List<String> updatedList = new ArrayList<>();
		updatedList.clear();
		for( String booking:bookingDetails) {
			if(booking.split(",")[0].equals(String.valueOf(bookingId))) {
			//	0	1		2			3		4	5		6		7		8		9			10
			// Id, custID, fitnessname, month,date ,status, price, mem_count,rating, review , Fit_classID

				
			String tempString = 
							booking.split(",")[0]+","+
							booking.split(",")[1]+","+
							booking.split(",")[2]+","+
							booking.split(",")[3]+","+
							booking.split(",")[4]+","+
							status+","+
							booking.split(",")[6]+","+
							booking.split(",")[7]+","+
							booking.split(",")[8]+","+
							booking.split(",")[9]+","+
							booking.split(",")[10]
							;
			
			System.out.println("old-->"+booking);
			System.out.println("new string is"+tempString);
							updatedList.add(tempString);
			}
			else {
				updatedList.add(booking);
			}
			
		}
		return updatedList;
	}



	public List<List<String>>   changeBooking(List<String> timeTableList, List<String> bookingDetailsList) {
		
		
		Scanner sc = new Scanner(System.in);
		Customer cust = new Customer();
		GroupSession gs = new GroupSession();
		Modify modify = new Modify();
		System.out.println("Enter you customer ID: (Sample input: cust01,cust02...");
		String custID = sc.next();
		boolean isCustomerValid = cust.validateCustomer(custID);
		while(!isCustomerValid) {
			System.out.println("You have entered wrong customerID\n"
					+ "Enter Valid Customer ID:");
			custID  = sc.next();
			isCustomerValid = cust.validateCustomer(custID);
		}
		System.out.println("Availble bookings with this customer ID:"+custID);

		System.out.println("======================================================");
		System.out.println("BookingId\t Fitness \t Date\t\t Status");
		System.out.println("======================================================");
		
		int count=0;
		for(String data :bookingDetailsList) {
			if(data.split(",")[1].equals(custID)) {
				System.out.println(
						data.split(",")[0]+"\t\t"+
						data.split(",")[2]+"\t\t"+
						data.split(",")[4]+"\t"+		
						data.split(",")[5]
						);
			}
			if(data.split(",")[1].equals(custID)&& data.split(",")[5].equals("booked")) {
				count++;
			}
		}
		System.out.println("--------------------------------------------------------");
		if(count ==0) {
			System.out.println("You don't have any pending sessions to modify booking.. ");
			return null;
		}
		System.out.println("enter booking Id to modify the session");
		String modifyId = sc.next();
		boolean flag = true;
		String bookInfo = "";
		for(String data :bookingDetailsList) {
			
			if(data.split(",")[0].equals(modifyId)&& data.split(",")[5].equals("booked")) {
				flag = false;
				bookInfo =data;
			}
		}
		if(flag) {
			System.out.println("Please choose class Id which is in booked status.. ");
			return null;
		}
		
		//update time table and modify status to changed
		timeTableMod = gs.updateTimetable(timeTableList, Integer.valueOf(bookInfo.split(",")[10]), -Integer.valueOf(bookInfo.split(",")[7]));
		bookingDataMod = modify.updateStatus(bookingDetailsList, modifyId,"changed");
		modifiedList.clear();
		modifiedList = gs.bookASession(timeTableMod,bookingDataMod,custID);
		if(modifiedList.isEmpty()) {
			modifiedList.clear();
			modifiedList.add(timeTableList);
			modifiedList.add(bookingDetailsList);
		}
		//
		/*
		 * 
		 * modifiedList.clear(); modifiedList.add(timeTableMod);
		 * modifiedList.add(bookingDataMod);
		 */
		System.out.println("Modified booking successful..");
		return modifiedList;
	}

	
}
