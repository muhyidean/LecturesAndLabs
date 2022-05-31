package lesson4.lecture.staticinherit.second;

@SuppressWarnings("static-access")
//they cannot be used polymorphically
public class Sub extends Super {
	public static void main(String[] args) {  
		Sub s = new Sub();
		s.print();
//		Super.print();
	}

	public static void print() {

		System.out.println("bye");
	}
}
