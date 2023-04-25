package com.uh.wfc;

import java.util.HashMap;


public class Customer {
	
	public static HashMap<String, String> custData ;
	
	public void custDetails(){
		
		 
		 custData = new HashMap<String, String>();

		custData.put("cust01","Alice");
		custData.put("cust02","Madhu");
		custData.put("cust03","Nikki");
		custData.put("cust04","Lucky");
		custData.put("cust05","Danny");
		custData.put("cust06","Dave");
		custData.put("cust07","Abbie");
		custData.put("cust08","Monna");
		custData.put("cust09","Gilbert");
        custData.put("cust10","Joseph");
        custData.put("cust11","Oliver");
        custData.put("cust12","Thomas");
		custData.put("cust13","William");
		custData.put("cust14","David");
	    custData.put("cust15","Jonson");
        custData.put("cust16","Olivia");
            
	}
	
	public boolean validateCustomer(String customerID) {
		Customer custInf= new Customer();
		custInf.custDetails();
		//System.out.println("is valid"+custData.containsKey(customerID)+"---"+customerID);
		return custData.containsKey(customerID);
	}

}
