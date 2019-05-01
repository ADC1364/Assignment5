package bestbuy;

public class SummerGreeting implements SecondaryHeading {

	public SummerGreeting() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applies(PurchasedItems items) {
		// // SecondaryHeading decorators always applied	
		return true;
	}

	@Override
	public String getLines() {
		
		return "Bestbuy wishes you a great Summer Vacation!";
	}

}
