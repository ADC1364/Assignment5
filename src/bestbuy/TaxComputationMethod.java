package bestbuy;

public abstract class TaxComputationMethod {
	
	public abstract double computeTax(PurchasedItems items, Receipt r); 
	
	protected abstract boolean taxHoliday(Receipt r);
}
