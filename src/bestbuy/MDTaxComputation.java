package bestbuy;

public class MDTaxComputation extends TaxComputationMethod {

	public MDTaxComputation() {
		// TODO Auto-generated constructor stub
	}
	
	public double computeTax(PurchasedItems items, Receipt r) {
		return 0;
		// calls private method taxHoliday as part of this computation
		
	}
	
	protected boolean taxHoliday(Receipt r) {
		return false;
		// returns true if date of receipt within the state’s tax free holiday,
		// else returns false. Supporting method of method computeTax.
		
	}

}
