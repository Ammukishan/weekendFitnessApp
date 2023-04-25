package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;

public class BookingInfo {

	/***
	 * 
	 * Id, custID,fitnessname, month,date ,status, price, mem_count,rating, review, Fit_classID
	 * 
	 * 
	 */


private static List<String> bookingDetails;
	
	public List<String> custDeatils(){
		
		 
		 bookingDetails = new ArrayList<String>();

		 bookingDetails.add("1,cust01,zumba,3,3/18/2023,attended,50,1,4,good session,10");
		 bookingDetails.add("2,cust02,gym,3,3/4/2023,cancelled,50,1,,,1");
		 bookingDetails.add("3,cust03,swim,4,4/2/2023,attended,45,4,5,not really good,20");
		 bookingDetails.add("4,cust02,spin,4,4/8/2023,attended,70,1,5,not good,22");
		 bookingDetails.add("5,cust02,zumba,3,3/18/2023,attended,50,3,4,good  asd session,10");
		 bookingDetails.add("6,cust06,boxing,4,4/9/2023,attended,60,1,5,not really good,24");
		 bookingDetails.add("7,cust07,boxing,4,4/9/2023,attended,60,1,5,enjoyed session,24");
		 bookingDetails.add("8,cust07,spin,4,4/2/2023,attended,70,4,5,enjoyed session,19");
		 bookingDetails.add("9,cust08,boxing,4,4/9/2023,attended,60,1,5,bad session,24");
		 bookingDetails.add("10,cust09,boxing,4,4/9/2023,attended,60,1,5,Awesome,24");
		 bookingDetails.add("11,cust05,gym,3,3/12/2023,attended,50,1,5,good one,7");
		 bookingDetails.add("12,cust04,spin,4,4/8/2023,booked,70,4,,,22");
		 bookingDetails.add("13,cust08,zumba,3,3/26/2023,booked,40,1,,,16");		 
		 bookingDetails.add("14,cust09,yoga,4,4/16/2023,attended,55,1,2,good session done a great,27");
		 bookingDetails.add("15,cust12,zumba,4,4/30/2023,changed,40,1,,,33");
		 bookingDetails.add("16,cust13,dance,4,4/7/2023,cancelled,60,1,,,35");
		 
		 return bookingDetails;
		
           
            
	}
	

}
