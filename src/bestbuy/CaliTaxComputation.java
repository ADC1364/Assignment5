package bestbuy;

import java.util.Date;

public class CaliTaxComputation extends TaxComputationMethod {

	public CaliTaxComputation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeTax(PurchasedItems items, Date date) {
		// calls private method taxHoliday as part of this computation
				double tax = 0;
				
				double sum = items.getTotalCost();
				
				if(!taxHoliday(date))
					tax = sum * 0.08; // California sales tax is about 8%
				return tax;
	}

	@Override
	protected boolean taxHoliday(Date date) {
		// will always have sales tax.
		return false;
		// returns true if date of receipt is within the state’s tax free holiday,
		// else returns false. Supporting method of method computeTax.
	}

}
