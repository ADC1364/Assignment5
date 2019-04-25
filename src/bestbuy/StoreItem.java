package bestbuy;

public class StoreItem {
	private String itemCode; // e.g., 3010 
	private String itemDescription; // e.g., Dell Laptop 
	private double itemPrice;
	
	public StoreItem(String code, String descript, double price){ 
		
		this.itemCode = code;
		this.itemDescription = descript;
		this.itemPrice = price;
	}
	
	// appropriate getters and setters
	
	public String getItemCode () { return this.itemCode; }
	public void setItemCode (String newCode) { this.itemCode = newCode; }
	
	public String getItemDescription() { return this.itemDescription; }
	public void setItemDescription(String newDescription) { this.itemDescription = newDescription; }
	
	public double getPrice() { return this.itemPrice; }
	public void setItemPrice(double newPrice) { this.itemPrice = newPrice; }
	
	public String toString() { return "Item code is: " + this.itemCode + " Item description: " + this.itemDescription + " $ " + this.itemPrice; }
}
