package lesson3.labs.prob3;


public class Driver {

	public static void main(String[] args) {
		Address[] addresses = {
				new Address("111 Main", "Fairfield", "IA", "52556"),
				new Address("200 Forest Ave", "Fairfield", "IA", "52556"),
			    new Address("10 N. 4th St.", "Fairfield", "IA", "52556")
		};
		Object[] objects = { 
				new House(addresses[0], 1200.0), 
				new Condo(addresses[1], 2), 
				new Trailer(addresses[2]) 
		};
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println(totalRent);
	}
}
