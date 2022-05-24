package lesson2.lecture.unidirectional.oneone_restrict;

public class Customer {
	private String name;
	private ShoppingCart cart;
	public Customer(String name) {
		this.name = name;
		cart = new ShoppingCart();		
	}
	public String getName() {
		return name;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	
	public void addToCart(Item item) {
		cart.addItem(item);
	}
	
	public String toString() {
		if(cart == null) return "null";
		return name + ": " + cart.getItems().toString();
		
	}
}
