package lesson2.lecture.unidirectional.oneToZeroOne.external;

import lesson2.lecture.unidirectional.oneToZeroOne.Customer;
import lesson2.lecture.unidirectional.oneToZeroOne.ShoppingCart;

public class Main {
	
	public static void main (String [] args) {
		
		Customer c1 = new Customer("Dean");
		Customer c2 = new Customer("John");
		c1.setCart();
		System.out.println(c1.getCart());

		c1.setCart();
		System.out.println(c1.getCart());
//		
//		ShoppingCart shop = ShoppingCart.newShoppingCart(c1);
//		ShoppingCart shop2 = ShoppingCart.newShoppingCart(c2);
//		
//		System.out.println(c1.getCart());
//		System.out.println(c2.getCart());
	
//		c1.createCart();
//		System.out.println(c1.getCart());
//		c1.createCart();
//		System.out.println(c1.getCart());
//		
//		ShoppingCart shop = ShoppingCart.newShoppingCart(c1);
//		System.out.println(c1.getCart());
//		System.out.println(shop);
		
//		System.out.println(c2.getCart());
//		
		
	}

}
