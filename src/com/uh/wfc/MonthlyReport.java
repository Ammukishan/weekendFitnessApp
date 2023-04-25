package com.uh.wfc;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MonthlyReport {

	public void monthLessonReport(List<String> bookingDetailsList, int month) {
			//  0		1		2		3	 4		5		6		7		  8			9
			// Id, custID,fitnessname, month,date ,status, price, mem_count,rating, review
			HashMap< String, String> monRepMap = new HashMap<>();
			
			// key=> fitness  	value=> amount,members,rating
			
			for (String bookData : bookingDetailsList) {
				
				if(bookData.split(",")[5].equals("attended") && bookData.split(",")[3].equals(String.valueOf(month))  ) {
					boolean check = monRepMap.containsKey(bookData.split(",")[2]+"-"+bookData.split(",")[4]);
					//System.out.println("check value+"+check+"--"+bookData.split(",")[2]+"-"+bookData.split(",")[4]);
					if (check==true) {
						String data = monRepMap.get(bookData.split(",")[2]+"-"+bookData.split(",")[4]);
						int priceUpdated = Integer.valueOf(data.split(",")[0])  +Integer.valueOf(bookData.split(",")[6]);
						int membersUpdated =Integer.valueOf(data.split(",")[1])  +Integer.valueOf(bookData.split(",")[7]);
						int ratingUpdated =Integer.valueOf(data.split(",")[2])  +(Integer.valueOf(bookData.split(",")[8])*Integer.valueOf(bookData.split(",")[7]));
										
						String val= String.valueOf(priceUpdated)+","+String.valueOf(membersUpdated)+","+String.valueOf(ratingUpdated);
						//monRepMap.replace(bookData.split(",")[2], val);
						monRepMap.replace(bookData.split(",")[2]+"-"+bookData.split(",")[4], val);
					}
					else {
						//1,cust01,yoga,3,date,attended,50,1,good session");
						int rat = Integer.valueOf(bookData.split(",")[7])*Integer.valueOf(bookData.split(",")[8]);
						monRepMap.put(bookData.split(",")[2]+"-"+bookData.split(",")[4], 
										bookData.split(",")[6]+","  //price
										+ bookData.split(",")[7]+"," //members
										//+ bookData.split(",")[8]  //rating
										+ String.valueOf(rat)
								);
						
					
					}
				}
			}

			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Fitness Type\t price\t\tAverage rating\t\tDate\t\tTotal Attendees");
			System.out.println("--------------------------------------------------------------------------------------");
				 for (Entry<String, String> set :
		             monRepMap.entrySet()) {
		            // Printing all elements of a Map
		            System.out.println(set.getKey().split("-")[0] + "\t\t "
		                    + set.getValue().split(",")[0]+"\t\t\t"
		                            + Integer.valueOf(set.getValue().split(",")[2])
		                                    /Integer.valueOf(set.getValue().split(",")[1])+"\t\t"
		                                    
		                                    +set.getKey().split("-")[1]+"\t\t"
		                    	    +        set.getValue().split(",")[1]               		   
		            		);
		        }
			
			System.out.println("--------------------------------------------------------------------------------------");
						
			System.out.println("Month Report generated successfully...");
	}

}
