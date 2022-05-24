package lesson7.lecture.equals.sameclass.theproblem;

public class Test {

	public static void main(String[] args) {
		PersonWithJob joe1 = new PersonWithJob("Joe", 50000);
		PersonWithJob joe2 = new PersonWithJobWithCounter("Joe", 50000);
		System.out.println(joe2.equals(joe1)); // value is false since joe2 is not of same type as joe1
	}
}
