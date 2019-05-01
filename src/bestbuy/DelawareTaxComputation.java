package bestbuy;

import java.util.Date;

public class DelawareTaxComputation extends TaxComputationMethod {

	public DelawareTaxComputation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeTax(PurchasedItems items, Date date) {
		// TODO Auto-generated method stub
		
		// there is no sales tax in Delaware
		return 0;
	}

	@Override
	protected boolean taxHoliday(Date date) {
		// TODO Auto-generated method stub
		return true;
	}

}
