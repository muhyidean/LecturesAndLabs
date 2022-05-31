package lesson5.lecture.factorymethods4.singleton;

public class MySingleton {
	public static int countInstances = 0;

	private static MySingleton instance = new MySingleton();

	private MySingleton() {
		++countInstances;
	}

	public static MySingleton getInstance() {
		return instance;
	}




	public static void main(String[] args) {
		MySingleton obj = MySingleton.getInstance();
		System.out.println(obj);

		MySingleton obj2 = MySingleton.getInstance();
		System.out.println(obj2);


	}
}


