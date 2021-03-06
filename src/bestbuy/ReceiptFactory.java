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
	private AddOn[] addOns ; // secondary heading, rebate and coupon add-ons (hardcoded here)
	
	
	public ReceiptFactory() { // constructor
		
				// state tax computation objects
				MDTaxComputation mdTax = new MDTaxComputation ();
				CaliTaxComputation caliTax = new CaliTaxComputation ();
				DelawareTaxComputation delawareTax = new DelawareTaxComputation ();
				
				// AddOns, can choose between summer of holiday greeting for secondary header
				SecondaryHeading holidayGreeting = new HolidayGreeting();
				SecondaryHeading summerGreeting = new SummerGreeting();
				
				
				Rebate rebate1406 = new Rebate1406();
				Coupon coupon100 = new Coupon100Get10Percent();
				
				
				taxComputationsObjs = new TaxComputationMethod[50];
				taxComputationsObjs [0] = mdTax;
				taxComputationsObjs [1] = caliTax;
				taxComputationsObjs [2] = delawareTax;
				
				addOns = new AddOn[3]; //I hard coded 3
				//addOns[0] = summerGreeting;
				//addOns[1] = rebate1406;
				//addOns[2] = coupon100;
		
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
        
        
		
	}
	
	public Receipt getReceipt(PurchasedItems items, Date date) {
		
		
		
		Receipt newReceipt = new BasicReceipt(items, date);
		
		((BasicReceipt) newReceipt).setStoreHeader(this.store_header);
		
		if(store_header.getStateCode().equals("MD"))
			((BasicReceipt) newReceipt).setTaxComputationMethod(taxComputationsObjs[0]);
		else if(store_header.getStateCode().equals("CA"))
			((BasicReceipt) newReceipt).setTaxComputationMethod(taxComputationsObjs[1]);
		else if(store_header.getStateCode().equals("DE"))
			((BasicReceipt) newReceipt).setTaxComputationMethod(taxComputationsObjs[2]);
		
		
		
		for(int i = 0; i< addOns.length; i++) {
			
			try {
			if(addOns[i].applies(items)) {
				
				if(addOns[i] instanceof SecondaryHeading)
					 newReceipt = new PreDecorator(newReceipt, addOns[i]);
				
				else if(addOns[i] instanceof Rebate)
					 newReceipt = new PostDecorator(newReceipt, addOns[i]);
				
				else if(addOns[i] instanceof Coupon)
					 newReceipt = new PostDecorator(newReceipt, addOns[i]);
					
				
			}
			}
			catch(NullPointerException e) {}
		}
		
		
		
		return newReceipt;
		// 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
			//If of type SecondaryHeader, then creates a PreDecorator for othe AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
		
		// 5. Links in the decorator object based on the Decorator design pattern.
		// 6. Returns decorated BasicReceipt object as type Receipt.
}
}
