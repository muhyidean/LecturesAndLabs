package lesson2.lecture.unidirectional.onemany_alt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
	private LocalDate orderDate;
	private List<Item> items;
	
	public Order(Customer cust, LocalDate orderDate) {
		if(cust == null) 
			throw new IllegalArgumentException("Customer cannot be null");
		this.orderDate = orderDate;
		items = new ArrayList<Item>();
		cust.addOrder(this);
	}
	public void addItem(String name){
		items.add(new Item(name));
	}
	@Override
	public String toString() {
		return orderDate + ": " + 
	              items.toString();
	}
}
