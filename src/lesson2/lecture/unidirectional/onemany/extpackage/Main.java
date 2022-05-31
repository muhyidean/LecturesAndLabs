package lesson2.lecture.unidirectional.onemany.extpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lesson2.lecture.unidirectional.onemany.Customer;
import lesson2.lecture.unidirectional.onemany.*;

public class Main {
	public static void main(String[] args) {
		Customer cust = new Customer("Bob");
		Order order = cust.addOrder(LocalDate.now());
		order.addItem("Shirt");
		order.addItem("Laptop");
		order = cust.addOrder(LocalDate.now());
		order.addItem("Pants");
		order.addItem("Knife set");
//		System.out.println(cust.getOrders());
		//cannot directly create an Order here

		List<Customer> customers = new ArrayList<>();
		customers.add(cust);

		System.out.println(getItems(customers));


	}

	public static List<Item> getItems (List<Customer> customers){

		return
				customers.stream()
				.flatMap(c -> c.getOrders().stream())
						.limit(1)
				.flatMap(o -> o.getItems().stream())
				.collect(Collectors.toList());
	}
}

		
