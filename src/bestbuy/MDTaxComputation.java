package bestbuy;

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
		
		
		Date after = new Date();
		after.setDate(19);
		after.setMonth(2);
		
		Date before = new Date();
		after.setDate(21);
		after.setMonth(2);
		
		if(date.after(after) && date.before(before))
			return true;
		
		return false;
		// returns true if date of receipt within the state’s tax free holiday,
		// else returns false. Supporting method of method computeTax.
		
	}

}
