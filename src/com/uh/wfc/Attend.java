package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attend {
	String custID ;
	public List<String> attendASession(List<String> bookingDetailsList) {
		
		Scanner sc = new Scanner(System.in);
		Customer cust = new Customer();
		Attend attnd = new Attend();
		
		System.out.println("Enter you customer ID: (Sample input: cust01,cust02...");
		custID = sc.next();
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
			return bookingDetailsList;
		}
		System.out.println("enter booking Id to attend");
		String bookingId = sc.next();
		System.out.println("Provide Session Rating rangin 1 - 5"
				+ "\n(1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied)");
		int rating = sc.nextInt();
		 while (rating < 1 || rating > 5) {
			  System.out.println("Provide valid Rating (Range between: 1 to 5)"); 
			  rating = sc.nextInt(); 
		  }
		System.out.println("Enter Review:");
		String review = sc.nextLine();
		review=sc.nextLine();
		bookingDetailsList = attnd.updateReview(bookingDetailsList, bookingId, rating,review);
		
		return bookingDetailsList;
	}
	
	public List<String> updateReview(List<String> bookingDetails,String bookingId, int rating, String review){
		List<String> updatedList = new ArrayList<>();
		updatedList.clear();
		for( String booking:bookingDetails) {
			if(booking.split(",")[0].equals(String.valueOf(bookingId))) {
			//	0	1		2			3		4	5		6		7		8		9			10
			// Id, custID,fitnessname, month,date ,status, price, mem_count,rating, review,  Fit_classID

				
			String tempString = 
							booking.split(",")[0]+","+
							booking.split(",")[1]+","+
							booking.split(",")[2]+","+
							booking.split(",")[3]+","+
							booking.split(",")[4]+","+
							"attended"+","+
							booking.split(",")[6]+","+
							booking.split(",")[7]+","+
							String.valueOf(rating)+","+
							review+","+
							booking.split(",")[10]
							
							;
			updatedList.add(tempString);
			}
			else {
				updatedList.add(booking);
			}
			
		}
		System.out.println("Attended class successfully..");
		return updatedList;
	}

}
