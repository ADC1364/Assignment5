package bestbuy;

public class Rebate1406 implements Rebate {

	public Rebate1406() {
		// TODO Auto-generated constructor stub
	}

	public boolean applies(PurchasedItems items) { 
		
		return items.containsItem("1406");
	}
	
	public String getLines() {
		
		return "Mail-in Rebate for Item #1406\n" + "Name:\n" + "Address:\n\n" + "Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
	
	}

}
