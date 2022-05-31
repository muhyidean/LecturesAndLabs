package lesson4.lecture.staticinherit.fourth;

public class Sub extends Super {
	public static void main(String[] args) {
//		super.tryit(); //compiler error
		tryit();
	}
	public static void tryit() {
		System.out.println("trying it too");
	}
}
