package lesson2.lecture.unidirectional.oneone_restrict;
import java.util.*;

//not visible to outside
class ShoppingCart {
	private List<Item> items;
	public void addItem(Item item) {
		items.add(item);
	}
	//package level
	ShoppingCart() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}
}
