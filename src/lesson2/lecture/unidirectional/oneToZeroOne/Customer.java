package lesson2.lecture.unidirectional.oneToZeroOne;

public class Customer {
	private String name;
	private ShoppingCart cart;
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public	void setCart() {
		this.cart = ShoppingCart.newShoppingCart(this);
	}
		
	public ShoppingCart getCart() {
		return cart;
	}
}
