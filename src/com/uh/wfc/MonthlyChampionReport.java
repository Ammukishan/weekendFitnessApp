package com.uh.wfc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MonthlyChampionReport {
	public HashMap< String, String> monRepMap ;
	public void monthChampionReport( List<String> bookInfo, int month) {
		//  0		1		2		3	 4		5		6		7		  8			9
		// Id, custID,fitnessname, month,date ,status, price, mem_count,rating, review
		//HashMap< String, String>
		monRepMap = new HashMap<>();
		
		// key=> fitness  	value=> amount,members,rating
		
		for (String bookData : bookInfo) {
			
			if(bookData.split(",")[5].equals("attended") && bookData.split(",")[3].equals(String.valueOf(month))  ) {
				boolean check = monRepMap.containsKey(bookData.split(",")[2]);
				
				if (check) {
					
					String data = monRepMap.get(bookData.split(",")[2]);
					
					int priceUpdated = Integer.valueOf(data.split(",")[0])  +Integer.valueOf(bookData.split(",")[6]);
					int membersUpdated =Integer.valueOf(data.split(",")[1])  +Integer.valueOf(bookData.split(",")[7]);
					int ratingUpdated =Integer.valueOf(data.split(",")[2])  +(Integer.valueOf(bookData.split(",")[8])*Integer.valueOf(bookData.split(",")[7]));
									
					String val= String.valueOf(priceUpdated)+","+String.valueOf(membersUpdated)+","+String.valueOf(ratingUpdated);
					monRepMap.replace(bookData.split(",")[2], val);
				}
				else {
					//1,cust01,yoga,3,date,attended,50,1,good session");
					int rat = Integer.valueOf(bookData.split(",")[7])*Integer.valueOf(bookData.split(",")[8]);
					monRepMap.put(bookData.split(",")[2], 
									bookData.split(",")[6]+","  //price
									+ bookData.split(",")[7]+"," //members
									//+ bookData.split(",")[8]  //rating
									+ String.valueOf(rat)
							);
					
				
				}
			}
		}


		
	

	List< String> champlist= new ArrayList< String>();
	int tempMax=0;
	String key=null,value="";
	int count=monRepMap.size();
	// iterates till the HashMap having the elements
	while(count>0) {
		 for(Entry<String, String> cp:monRepMap.entrySet()) {
			// key=cp.getKey();
			 int arrVal = Integer.valueOf( cp.getValue().split(",")[0]);
			 if(arrVal>tempMax) {
				 tempMax=arrVal;
				 key=cp.getKey();
				 value=cp.getValue();
			 }
		}
		tempMax=0;
		champlist.add(key+","+value);
		monRepMap.remove(key);		
		count=monRepMap.size();		
	 }
	
	int rank=1;
	System.out.println("================================================================");
	System.out.println("Rank\tFitness\t\tTotal Price\tAverage Rating");
	System.out.println("----------------------------------------------------------------");
	for (String champ :champlist) {
		
		System.out.println(rank+"\t"+champ.split(",")[0]+"\t\t"+champ.split(",")[1]+"\t\t\t"+
				Integer.valueOf( champ.split(",")[3])/Integer.valueOf( champ.split(",")[2])
				);
		rank++;
	}
	System.out.println("----------------------------------------------------------------");
	System.out.println("Month Champion Report generated successfully...");
	}
}
