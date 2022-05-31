package lesson9.lecture.generate;
import lesson5.labs.prob4.Customer;
import lesson9.labs.prob3.Employee;

import java.util.Random;
import java.util.stream.*;
public class Examples {

	public static void main(String[] args) {
		Stream<String> stream0 = Stream.generate(() -> "Echo ");
		Stream<Integer> stream1 = 
			Stream.generate(() -> new Random().nextInt());
		//s -> System.out.print(s)
		//stream0.limit(5).collect(Collectors.toList()).forEach(System.out::print);

		System.out.println("\n");

		stream1
				.limit(10)
				.forEach(s -> System.out.print(s + "  "));

		Stream<Customer> streamCust = Stream.generate( () -> new Customer("dean"));
		streamCust
				.limit(5)
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
	}
}
