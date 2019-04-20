package bestbuy;

import java.util.Date;
import java.util.Iterator;

public class BasicReceipt implements Receipt {
	private StoreHeader store_header; // street address, state code, phone number, store number 
	private TaxComputationMethod tc;
	protected Date Date; // may also be a String type 
	private PurchasedItems items;
	
	
	public BasicReceipt(PurchasedItems items, Date date) { // Date may also be a String type 
		
		this.items = items;
		this.Date = date;
		
	}
	
	
	public void setStoreHeader(StoreHeader h) {store_header = h;}
	
	
	public void setTaxComputationMethod(TaxComputationMethod tc) { this.tc = tc; }
	
	
	
	public void prtReceipt() {
		
		System.out.println(store_header.toString());
		
		System.out.println(Date.toString());
		
		Iterator itr = items.getPurchasedItemIterator();
		
		while(itr.hasNext()) {
			
			StoreItem item = (StoreItem) itr.next();
			System.out.println(item.getItemCode() + "   " + item.getItemDescription() + "   $ " + item.getPrice());
			
		}
		
		System.out.println("The total without tax is: $ "+ items.getTotalCost());
		
		// I am having trouble with this line it causes a null pointer exception
		
		double tax = tc.computeTax(items, Date);
		
		
	}
}
