package inclassdemos.lesson2;

public class Main {

	public static void main(String[] args) {
		
		Student std1 = new Student(111,"Dean",3.7,new Address());
		
		System.out.println(std1.getAddress().city);

	}

}
