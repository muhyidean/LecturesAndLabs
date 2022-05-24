package lesson7.lecture.equals.asymmetry;

public class Test {

	public static void main(String[] args) {
		Person p = new Person("Joe");
		PersonWithJob withJob = new PersonWithJob("Joe", 100000);
	
		System.out.println(p.equals(withJob)); 

		System.out.println(withJob.equals(p)); 

	}
}
