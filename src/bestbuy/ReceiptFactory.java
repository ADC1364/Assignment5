package bestbuy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReceiptFactory {
	StoreHeader store_header; // contains street_addr, zip_code, state_code, phone num, store num 
	private TaxComputationMethod[] taxComputationsObjs; // tax computation objs (for each state) 
	private AddOn[] addOns; // secondary heading, rebate and coupon add-ons (hardcoded here)
	
	// I added this to store the chosen tax computation object (based on the config file) in the Receipt factory object
	TaxComputationMethod choosenStateTax;
	
	
	
	
	
	
	public ReceiptFactory() { // constructor
		
		// state tax computation objects
		MDTaxComputation mdTax = new MDTaxComputation ();
		
		// AddOns
		SecondaryHeading holidayGreeting = new HolidayGreeting();
		Rebate rebate1406 = new Rebate1406();
		Coupon coupon100 = new Coupon100Get10Percent();
		
		
		taxComputationsObjs = new TaxComputationMethod[50];
		taxComputationsObjs [0] = mdTax;
		
		addOns = new AddOn[3]; //I hard coded 3
		addOns[0] = holidayGreeting;
		addOns[1] = rebate1406;
		addOns[2] = coupon100;
		
		ArrayList <String> config = new ArrayList <String>();
		
		// pass the path to the file as a parameter 
	    File file = 
	      new File("C:\\Users\\aviel\\eclipse-workspace\\Assignment5\\src\\config"); 
	    Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		} 
	  
	    while (sc.hasNextLine()) 
	      config.add(sc.nextLine()); 
        
        store_header = new StoreHeader(config.get(0), config.get(1),config.get(2), config.get(3),config.get(4));
        
        if(store_header.getStateCode().equals("MD"))
        	choosenStateTax = taxComputationsObjs[0]; 
		
	}
	
	public Receipt getReceipt(PurchasedItems items, Date date) {
		
		
		
		Receipt newReceipt = new BasicReceipt(items, date);
		
		((BasicReceipt) newReceipt).setStoreHeader(this.store_header);
		
		((BasicReceipt) newReceipt).setTaxComputationMethod(choosenStateTax);
		
		
		
		for(int i = 0; i< addOns.length; i++) {
			
			if(addOns[i].applies(items)) {
				
				if(addOns[i] instanceof SecondaryHeading)
					 newReceipt = new PreDecorator(newReceipt, addOns[i]);
				
				else if(addOns[i] instanceof Rebate)
					 newReceipt = new PostDecorator(newReceipt, addOns[i]);
				
				else if(addOns[i] instanceof Coupon)
					 newReceipt = new PostDecorator(newReceipt, addOns[i]);
					
				
			}
			
		}
		
		
		
		return newReceipt;
		// 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
			//If of type SecondaryHeader, then creates a PreDecorator for othe AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
		
		// 5. Links in the decorator object based on the Decorator design pattern.
		// 6. Returns decorated BasicReceipt object as type Receipt.
}
}
