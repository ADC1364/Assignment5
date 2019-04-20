package bestbuy;

import java.util.Date;

public class Client {

	public static void main(String[] args)
	{
	
		Date todaysDate = new Date();
		
		PurchasedItems itemsPurchased = new PurchasedItems();
		
		// hard coded some item purchases
		itemsPurchased.addItem(new StoreItem("1406", "TV", 300));
		itemsPurchased.addItem(new StoreItem("1209", "watch", 100));
		itemsPurchased.addItem(new StoreItem("1308", "game", 60));
		itemsPurchased.addItem(new StoreItem("1105", "movie", 20));
		
	// 3. Constructs a ReceiptFactory object.
	// 3. Prompts user for items to purchase, storing each in PurchasedItems.
	// 4. Calls the getReceipt method of the factory to obtain constructed receipt.
	// 5. Prints receipt by call to method prtReceipt.
		
		
	// get receipt date
	// (prompt user for current date)
		
		
	// display all available store items to user (to be implemented)
		
	// get all user selections (to be implemented)
		
		
	ReceiptFactory factory = new ReceiptFactory(); 
	
	Receipt receipt = factory.getReceipt(itemsPurchased, todaysDate); 
	
	receipt.prtReceipt();
	}

}
