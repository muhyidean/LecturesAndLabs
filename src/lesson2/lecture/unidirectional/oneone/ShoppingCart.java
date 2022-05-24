package lesson2.lecture.unidirectional.oneone;
import java.util.*;

public class ShoppingCart {
	private List<Item> items;
	
	//package level
		ShoppingCart() {
			items = new ArrayList<Item>();
		}
		
		
	public void addItem(Item item) {
		items.add(item);
	}
	
	public List<Item> getItems() {
		return items;
	}
}
