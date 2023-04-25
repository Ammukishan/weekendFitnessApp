package com.uh.wfc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupSession {

	/**
	 * booking class session
	 * 
	 */
	
	List<String> timeTableUpdated, bookingDataUpdated;
	List<List<String>> updatedList = new ArrayList<>();
	public List<List<String>> bookASession(List<String> timetable, List<String> bookingData,String custID){
		Scanner sc = new Scanner(System.in);
		GroupSession gs = new GroupSession();
		
		System.out.println("Choose option to get your timetalbe");
		System.out.println("1 - Fitness type\n2 - Saturday/sunday");
		System.out.println("Enter your option");
		int choice = sc.nextInt();
		
		int classId=0;
		
		  while(choice<1 || choice > 2) { 
			  System.out.println("Enter valid option\n1 - Fitness type\n2 - Saturday/sunday");
			  choice = sc.nextInt(); 
		  }
		 
		if(choice == 1) { //get time table with fitness type
			
			System.out.println("Enter fitness Type: (sample input: yoga, zumba, dance, karate, boxing, gym, spin, swim, and bodysculpt )");
			String Ftype = sc.next();
			int count=0;
			System.out.println("==================================================================");
			System.out.println("ClassID\t\tFitness\t\tDate\t\tPrice");
			System.out.println("-------------------------------------------------------------------");
			for (String ttble:timetable) {
				//	0			1				2		3						4		5
				// Fitness_ID	Fitness_type	Date	current_booking_count	price 	day
				if(ttble.split(",")[1].equalsIgnoreCase(Ftype)) {
					System.out.println(ttble.split(",")[0]+"\t\t"
							+ttble.split(",")[1]+"\t\t"
							+ttble.split(",")[2]+"\t"
							+ttble.split(",")[4]		
							
							);
					count++;
				}
			
			}
			System.out.println("-------------------------------------------------------------------");
		
			if(count==0) {
				System.out.println("Don't have Fitness classes with "+Ftype
						+"\nwe have different classes like(yoga, zumba, dance, karate, boxing, gym, spin, swim, and bodysculpt");
				return null;
			}
			
		}
		else if (choice==2) { //get timetable with Saturday or Sunday
			
			System.out.println("choose options:\n1 - Saturday\n2 - Sunday");
			int satSun= sc.nextInt();
			//System.out.println("fType is "+satSun);
			
			while(choice<1 || choice > 2) { 
				  System.out.println("Enter valid option\n1 - Saturday\n2 - sunday");
				  choice = sc.nextInt(); 
			  }
			
			String day = "";
			if (satSun==1) {
				day ="saturday";
				
			}
			else if (satSun ==2) {
				day = "sunday";
			}
			else {
				System.out.println("you have choosen wrong option\nStart booking again");
				return null;
			}
			System.out.println("============================================================");
			System.out.println("ClassID\t\tFitness\t\tDate\t\tPrice");
			System.out.println("------------------------------------------------------------");
			for (String ttble:timetable) {
				//	0			1				2		3						4		5
				// Fitness_ID	Fitness_type	Date	current_booking_count	price 	day
				if(ttble.split(",")[5].equalsIgnoreCase(day)) {
					System.out.println(ttble.split(",")[0]+"\t\t"
							+ttble.split(",")[1]+"\t\t"
							+ttble.split(",")[2]+"\t"
							+ttble.split(",")[4]		
							
							);
				}
				
			}
			System.out.println("------------------------------------------------------------");
		}
		
		
		System.out.println("Enter classId you wanna join");
		classId = sc.nextInt();
		//System.out.println("you have choosen optopn"+classId);
		String classRecord = null;
		for (String ttble:timetable) {
			//	0			1				2		3						4		5
			// Fitness_ID	Fitness_type	Date	current_booking_count	price 	day
			if(ttble.split(",")[0].equals(String.valueOf(classId))) {
				classRecord = ttble;
				break;
			}
		}
		//System.out.println("class record is:"+classRecord);
		//System.out.println("Enrolled count is --->>"+gs.getEnrollCount(timetable, classId));
		
		System.out.println("Enter number of attendees");
		int attendees= sc.nextInt();
		int enrollCount = gs.getEnrollCount(timetable, classId);
		if(enrollCount==-1) {
			System.out.println("you have entered wrong data.. So starting booking a class again");
			return null;
		}
		else if((enrollCount+attendees)>5) {
			System.out.println("Class is already full... Please choose some different class and start booking again!!");
			return null;
		}
		else if(gs.isAlreadyEnrolled(custID,bookingData,classRecord.split(",")[1])) {
			System.out.println("Already you have enrolled for this class..."
					+ "\nChoose different class and book again!!!");
			
		}
		else {
			//update timetable & booking list
			
			timetable = gs.updateTimetable(timetable, classId, attendees);
			bookingData = gs.updateBookingDetails(bookingData, classRecord,custID,String.valueOf(attendees));
			
			
			/*
			 * System.out.println("----------"); for (String ttble:timetable) {
			 * System.out.println(ttble); } System.out.println("========");
			 * System.out.println("size of time table is"+timetable.size()); for (String
			 * bdata:bookingData) { System.out.println(bdata); }
			 * System.out.println("========");
			 * System.out.println("updatedddd size of time table is"+timetable.size());
			 */
		
		}
		
		updatedList.clear();
		updatedList.add(timetable);
		updatedList.add(bookingData);
		
		return updatedList;
		
		
		
	}
	
	private boolean isAlreadyEnrolled(String custID, List<String> bookingData, String fitness) {
		for (String bdata:bookingData) {
			if(bdata.split(",")[1].equals(custID) && bdata.split(",")[2].equals(fitness)  ) {
				return true;
			}
		}
		return false;
	}
	
	private List<String> updateBookingDetails(List<String> bookingData,String fitnessInfo,String custId,String attendees) {
		List<String> bookingList = new ArrayList<>();
		for(String temp:bookingData) {
			bookingList.add(temp);
		}
		int rowId = bookingData.size()+1;
		//class record is:23,swim,4/9/2023,0,45,sunday
		
		// Id, custID,fitnessname, month,date ,status, price, mem_count,rating, review , Fit_classID
		//booking
		
		String append = rowId+","+custId+","+fitnessInfo.split(",")[1]+","+
				fitnessInfo.split(",")[2].split("/")[0]+","+
				fitnessInfo.split(",")[2]+","+"booked,"+
				fitnessInfo.split(",")[4]+","+attendees+","+","+","+fitnessInfo.split(",")[0]
				
				;
		//System.out.println("appndd->"+append);
		bookingList.add(append);
		
		return bookingList;
	}

	public int getEnrollCount(List<String> classInfo, int classID) {
				//		0			1				2		3					4		5
				// Fitness_ID	Fitness_type	Date	current_booking_count	price 	day
				
		for( String cinfo:classInfo) {
			if(cinfo.split(",")[0].equals(String.valueOf(classID))) {
				return Integer.valueOf(cinfo.split(",")[3]);
			}
		}
		return -1;
	}

	public List<String> updateTimetable(List<String> tTable,int classId, int attendees){
		List<String> newList = new ArrayList<>();
		//System.out.println("update time table");
		//System.out.println(classId+"----->>"+attendees);
		for( String ttInfo:tTable) {
			if(ttInfo.split(",")[0].equals(String.valueOf(classId))) {
				int count = Integer.valueOf(ttInfo.split(",")[3])+attendees;
				
				String append= ttInfo.split(",")[0]+","+
						ttInfo.split(",")[1]+","+
						ttInfo.split(",")[2]+","+
						String.valueOf(count)
								+","+
						ttInfo.split(",")[4]+","+
						ttInfo.split(",")[5];
				
					newList.add(append);
					
						
			}
			else {
				newList.add(ttInfo);
			}
		}
		
		return newList;
	}

}
