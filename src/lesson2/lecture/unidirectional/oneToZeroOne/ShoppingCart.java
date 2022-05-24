package lesson2.lecture.unidirectional.oneToZeroOne;

import java.util.*;

public class ShoppingCart {
	private List<Item> items;

	public void addItem(Item item) {
		items.add(item);
	}

	/** Use a factory method for construction */
	private ShoppingCart() {
		items = new ArrayList<Item>();
	}
	
	
	public static ShoppingCart newShoppingCart(
			                       Customer cust) {
		
		
		if (cust == null)
			throw new NullPointerException(
					              "Null customer");
		
		if(cust.getCart()!=null)
			return cust.getCart();
		
		return new ShoppingCart();
	}
	public List<Item> getItems() {
		return items;
	}
}
