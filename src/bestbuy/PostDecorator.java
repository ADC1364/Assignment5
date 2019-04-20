package bestbuy;

public class PostDecorator extends Decorator {
	
	
	public PostDecorator(Receipt r, AddOn a) { super(r, a); }
	
	public void prtReceipt() { 
		 
		callTrailer();
		
		System.out.println(addon.getLines());
		
	}
}
