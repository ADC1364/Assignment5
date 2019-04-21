package bestbuy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MDTaxComputation extends TaxComputationMethod {
	

	public MDTaxComputation() {
	}
	
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation
		double tax = 0;
		
		double sum = items.getTotalCost();
		
		if(!taxHoliday(date))
			tax = sum * 0.06;
		return tax;
			
		
	}
	
	protected boolean taxHoliday(Date date) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); //For declaring values in new date objects. use same date format when creating dates
		Date after = null;
		try {
			after = sdf.parse("02-19");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date before = null;
		try {
			before = sdf.parse("02-21");
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
		
		if( (current.after(after)) && (current.before(before) ))
			return true;
		
		
		//System.out.println(after);
		//System.out.println(current);
		//System.out.println(before);
		
		
		
		return false;
		// returns true if date of receipt within the state’s tax free holiday,
		// else returns false. Supporting method of method computeTax.
		
	}

}
