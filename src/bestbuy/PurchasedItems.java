package bestbuy;

import java.util.ArrayList;
import java.util.Iterator;

public class PurchasedItems {
	private ArrayList<StoreItem> items;
	
	public PurchasedItems() { items = new ArrayList<StoreItem>(); }

	public void addItem(StoreItem item) { items.add(item); } 
	
	public StoreItem getItem (int index) { return items.get(index); }
	
	public double getTotalCost() {
		
		int sum = 0;
		
		for(StoreItem item : items) {
			
			sum += item.getPrice();
		}
		
		return sum;
		
	}
	
	public boolean containsItem(String itemCode) {
		
		boolean hasItem = false;
		
		for(StoreItem item : items) {
			
			if(item.getItemCode().equals(itemCode))
				hasItem = true;
			
		}
		
		return hasItem;
		
	}
	
	public int getAmountOfItemsPurchased () {return this.items.size();}
	
	public Iterator<StoreItem> getPurchasedItemIterator() { return items.iterator();}
}
