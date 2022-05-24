package lesson3.lecture.personrole;

public class Main {
	/* Shows how a Person's role can be changed thanks to 
	 * the flexible design
	 */
	public static void main(String[] args) {
		Person joe = new Person();
		System.out.println("Here is Joe, showing his roles at startup."
				+ " He began as a Staff.");
		System.out.println("  " + joe);
		joe.changeRole(Staff.INSTANCE, Student.INSTANCE);
		System.out.println("Here is Joe, showing his roles after changing roles from Staff to Student.");
		System.out.println("  " + joe);
		

	}

}
