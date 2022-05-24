package lesson2.lecture.unidirectional.onemany_alt;

import java.time.LocalDate;
import java.util.*;

public class Customer {
	private String name;
	private List<Order> orders;
	public Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	public Order addOrder(Order ord) {
		orders.add(ord);
		return ord; 
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
}
