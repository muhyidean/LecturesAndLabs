package lesson7.lecture.eq;

/** Shows what goes wrong if equals is not overridden properly */
public class Person {
	private String name;
	public Person(String n) {
		this.name = n;
	}

	public boolean equals(Person p) {
		if(p == null) return false;
		Person q = (Person)p;
		return q.name.equals(name);
		
	}
}
