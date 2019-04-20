package bestbuy;

public class HolidayGreeting implements SecondaryHeading {

	public HolidayGreeting() {
		// TODO Auto-generated constructor stub
	}

	public boolean applies(PurchasedItems items) {
		return true; // SecondaryHeading decorators always applied	
	}
	
	public String getLines() {  return "* Happy Holidays from Best Buy *";  }

}
