package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {
	
	/**
	 * 
	 * 
	 * Fitness_ID	Fitness_type	Date	current_booking_count	price 	day
	 * 
	 * 
	 */

	
public static List<String> timeTable;
	
	public List<String> fitnessSchedule(){
		
		 
		 timeTable = new ArrayList<String>();

		 timeTable.add("1,gym,3/4/2023,1,50,saturday");
		 timeTable.add("2,zumba,3/4/2023,0,40,saturday");
		 timeTable.add("3,gym,3/5/2023,0,50,sunday");
		 timeTable.add("4,zumba,3/5/2023,0,40,sunday");
		 timeTable.add("5,karate,3/11/2023,0,60,saturday");
		 timeTable.add("6,boxing,3/11/2023,0,60,saturday");		 
		 timeTable.add("7,gym,3/12/2023,0,50,sunday");
		 timeTable.add("8,zumba,3/12/2023,0,40,sunday");
		 timeTable.add("9,gym,3/18/2023,0,50,saturday");
		 timeTable.add("10,zumba,3/18/2023,1,40,saturday");
		 timeTable.add("11,boxing,3/19/2023,0,60,sunday");
		 timeTable.add("12,Karate,3/19/2023,0,60,sunday");
		 timeTable.add("13,gym,3/25/2023,0,50,saturday");
		 timeTable.add("14,zumba,3/25/2023,0,40,saturday");
		 timeTable.add("15,gym,3/26/2023,0,50,sunday");
		 timeTable.add("16,zumba,3/26/2023,0,40,sunday");
		 timeTable.add("17,boxing,4/1/2023,0,60,saturday");
		 timeTable.add("18,dance,4/1/2023,0,60,saturday"); 
		 timeTable.add("19,spin,4/2/2023,4,70,sunday");
		 timeTable.add("20,swim,4/2/2023,4,45,sunday");
		 timeTable.add("21,gym,4/8/2023,0,50,saturday");
		 timeTable.add("22,spin,4/8/2023,1,70,saturday");
		 timeTable.add("23,swim,4/9/2023,0,45,sunday");
		 timeTable.add("24,boxing,4/9/2023,4,60,sunday");
		 timeTable.add("25,dance,4/15/2023,0,60,saturday");
	     timeTable.add("26,zumba,4/15/2023,0,40,saturday");
	     timeTable.add("27,yoga,4/16/2023,1,55,sunday");
	     timeTable.add("28,box fit,4/22/2023,0,60,saturday");
	     timeTable.add("29,aquacise,4/23/2023,0,50,sunday");
	     timeTable.add("30,dance,4/23/2023,0,60,sunday");
	     timeTable.add("31,bodysculpt,4/29/2023,0,55,saturday");
	     timeTable.add("32,spin,4/30/2023,0,70,sunday");
	     timeTable.add("33,zumba,4/30/2023,0,40,sunday");
	     timeTable.add("34,gym,4/6/2023,0,50,saturday");
	     timeTable.add("35,dance,4/7/2023,0,60,sunday");
		 return timeTable;
		
           
            
	}
	

}
