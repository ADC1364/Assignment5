package bestbuy;

import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Client {
	
	static PurchasedItems bestBuyItems = getItemsAvailable();

	public static void main(String[] args)
	{
	
		Date todaysDate = new Date();
		
		PurchasedItems itemsPurchased = new PurchasedItems();
		
		ReceiptFactory factory = new ReceiptFactory();
		
		Scanner input  = new Scanner(System.in);
		
		printAvailableItems();
		
		
		
		System.out.println("Please enter in the items you wish to purchase, enter zero to exit");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		
		int option = input.nextInt();
		
		do {
			switch(option) {
			
			case 0:
				break;
			
			case 1: itemsPurchased.addItem(bestBuyItems.getItem(option - 1));
			break;
			case 2: itemsPurchased.addItem(bestBuyItems.getItem(option - 1));
			break;
			case 3: itemsPurchased.addItem(bestBuyItems.getItem(option - 1));
			break;
			case 4: itemsPurchased.addItem(bestBuyItems.getItem(option - 1));
			break;
			
			
			
			}
			System.out.println("Please enter in the next item you wish to purchase, enter zero to exit");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
			
			option = input.nextInt();
			
		}while(option !=0);

		
		
	Receipt receipt = factory.getReceipt(itemsPurchased, todaysDate); 
	
	receipt.prtReceipt();
	}


	/**
	 * 
	 */
	public static void printAvailableItems() {
		PurchasedItems itemsAvailable = bestBuyItems;
		
		Iterator <StoreItem> itr = itemsAvailable.getPurchasedItemIterator();
		
		int count = 1;
		
		System.out.println("The items available at Bestbuy are: ");
		
		while(itr.hasNext()) {
			
			StoreItem item = itr.next();
			
			System .out.println("Item: " + count + " " + item.toString());
			
			count++;
		}
	}
	
	
	public static PurchasedItems getItemsAvailable () {
		
		PurchasedItems itemsAvailable = new PurchasedItems();
		
		itemsAvailable.addItem(new StoreItem("1406", "TV", 300));
		itemsAvailable.addItem(new StoreItem("1209", "watch", 100));
		itemsAvailable.addItem(new StoreItem("1308", "game", 60));
		itemsAvailable.addItem(new StoreItem("1105", "movie", 20));
		
		return itemsAvailable;
		
		
	}

}
