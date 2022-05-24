package lesson2.lecture.unidirectional.onemany_alt.extpackage;

import java.time.LocalDate;
import lesson2.lecture.unidirectional.onemany_alt.*;

public class Main {
	public static void main(String[] args) {
		//runtime exception if this is attempted
		//Order ord = new Order(Customer cust, LocalDate.now());
		Customer cust = new Customer("Bob");
		Order order = new Order(cust, LocalDate.now());
		order.addItem("Shirt");
		order.addItem("Laptop");
		order = new Order(cust, LocalDate.now());
		order.addItem("Pants");
		order.addItem("Knife set");
		System.out.println(cust.getOrders());
		//cannot directly create an Order here
	}
}

		
