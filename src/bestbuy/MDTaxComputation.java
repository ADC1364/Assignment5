package bestbuy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MDTaxComputation extends TaxComputationMethod {
	

	public MDTaxComputation() { }
	
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation
		double tax = 0;
		
		double sum = items.getTotalCost();
		
		if(!taxHoliday(date)) 
			tax = sum * 0.06; // sales tax is 6% in Maryland
		return tax;
			
		
	}
	
	protected boolean taxHoliday(Date date) {
		
		// change the after date and before date ( "MM - dd" ) to place today's current date within and a tax holiday with 0 sales tax will occur.
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); //For declaring values in new date objects. use same date format when creating dates
		Date after = null;
		try {
			after = sdf.parse("04-20");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date before = null;
		try {
			before = sdf.parse("05-25");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Date current = null;
		try {
			current = sdf.parse((date.getMonth()+1) + "-" + date.getDate() );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sales tax holiday occurs after this date: " + after + " and before this date: " + before);
		System.out.println("The current date is: " + current );
		
		if( (current.after(after)) && (current.before(before) ))
			return true;
		
		
		
		
		return false;
		// returns true if date of receipt is within the state’s tax free holiday,
		// else returns false. Supporting method of method computeTax.
		
	}

}
