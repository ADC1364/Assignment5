package bestbuy;

public class Coupon100Get10Percent implements Coupon {

	public Coupon100Get10Percent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applies(PurchasedItems items) {
		
		boolean over99 = false;
		
		// change value here to see the coupon appear, I changed it from 100 to 2 to make sure it was working correctly.
		if(items.getAmountOfItemsPurchased() >= 2)
			over99 = true;
		
		return over99;
	}

	@Override
	public String getLines() {
		
		return "You have earned a 10% off coupon for your next purchase due to purchasing over a 100 items"+ "\n"
		+ "Use this code when checking out with us on your next visit: PG65" + "\n";
	}

}
